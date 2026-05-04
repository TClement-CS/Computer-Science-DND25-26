import java.io.IOException;
import java.util.HashMap;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HuffmanCodeGenerator {

    private HashMap<Character, String> dictionary = new HashMap<>();
    private HashMap<Character, Integer> frequencyTable = new HashMap<>();

    public HuffmanCodeGenerator(String frequencyFile) throws IOException {
        frequencyTable = getFrequency(frequencyFile);
        HuffmanNode root = treeBuilder(frequencyTable);

        dictionary = new HashMap<>();
        if (root != null) {
            buildDictionary(root, "");
        }

    }

    public int getFrequency(char c) {
        if (frequencyTable.containsKey(c)) {
            return frequencyTable.get(c);
        } else {
            return 0;
        }
    }

    public HashMap<Character, Integer> getFrequency(String strFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(strFile));
        HashMap<Character, Integer> freqTable = new HashMap<>();
        int ch;
        while ((ch = br.read()) != -1) {
            char c = (char) ch;
            freqTable.put(c, freqTable.getOrDefault(c, 0) + 1);
        }
        br.close();
        freqTable.put((char) 26, 1); // end o file
        return freqTable;
    }

    public HuffmanNode treeBuilder(HashMap<Character, Integer> frequencyTable) {
        if (frequencyTable.isEmpty()) {
            return null;
        }
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyTable.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode(
                    left.frequency + right.frequency,
                    left,
                    right);

            pq.add(parent);
        }
        return pq.poll();
    }

    private void buildDictionary(HuffmanNode node, String code) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            dictionary.put(node.character, code);
            return;
        }
        buildDictionary(node.left, code + "0");
        buildDictionary(node.right, code + "1");
    }

    public String getCode(char c) {
        return dictionary.getOrDefault(c, "");
    }

    public void makeCodeFile(String codeFile) {
        if (dictionary == null || dictionary.isEmpty()) {
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(codeFile))) {
            for (Map.Entry<Character, String> entry : dictionary.entrySet()) {
                if (entry.getValue() != null && !entry.getValue().isEmpty()) {
                    writer.write(entry.getKey() + ":" + entry.getValue());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}