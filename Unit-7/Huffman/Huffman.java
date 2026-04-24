import java.io.IOException;
import java.util.HashMap;
import java.io.FileReader;
import java.io.BufferedReader;

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

    public 
}