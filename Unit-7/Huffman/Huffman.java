import java.io.IOException;
import java.util.HashMap;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Huffman {

    private HashMap<Character, String> dictionary;

    public Huffman(String fileName) throws IOException {
        HashMap<Character, Integer> freq = getFrequency(fileName);
        HuffmanNode root = treeBuilder(freq);

        dictionary = new HashMap<>();
        buildDictionary(root, "");
    }

    public HashMap<Character, Integer> getFrequency(String strFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(strFile));
        HashMap<Character, Integer> frequencyTable = new HashMap<>();
        while (br.ready()) {
            char c = (char) br.read();
            if (frequencyTable.containsKey(c)) {
                int frequency = frequencyTable.get(c);
                frequency++;
                frequencyTable.put(c, frequency);
            } else {
                frequencyTable.put(c, 1);
            }
        }
        return frequencyTable;
    }

    public HuffmanNode treeBuilder(HashMap<Character, Integer> frequencyTable) {
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
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            dictionary.put(node.character, code);
            return;
        }
        buildDictionary(node.left, code + "0");
        buildDictionary(node.right, code + "1");
    }

    public String getCode(char c) {
        if (dictionary.containsKey(c)) {
            return dictionary.get(c);
        } else {
            return "";
        }
    }

    public void makecode(String codeFile) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(codeFile));
            for (char c : dictionary.keySet()) {
                writer.write(c + ":" + dictionary.get(c));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}