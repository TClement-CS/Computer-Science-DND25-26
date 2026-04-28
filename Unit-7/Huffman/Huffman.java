import java.io.IOException;
import java.util.HashMap;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.util.Map;

public class Huffman {

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
}