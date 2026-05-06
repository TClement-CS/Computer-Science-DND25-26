import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class HuffmanDecoder {

    private HashMap<String, Character> dictionary = new HashMap<>();

    public HuffmanDecoder(String codeFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(codeFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] parts = line.split(":", 2);
                    if (parts.length == 2) {
                        char c = parts[0].charAt(0);
                        String code = parts[1];
                        dictionary.put(code, c);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading code file: " + e.getMessage());
        }
    }

    public boolean isCode(String binary) {
        return dictionary.containsKey(binary);
    }

    public char decodeChar(String binary) {
        return dictionary.get(binary);
    }

    public void decodeFileFromHuffmanCodes(String encodedFile, String decodedFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(encodedFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(decodedFile))) {

            StringBuilder bitBuffer = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                char bit = (char) ch;
                if (bit != '0' && bit != '1') { // skip not ones & zeros
                    continue; 
                }
                bitBuffer.append(bit);

                if (isCode(bitBuffer.toString())) {
                    char decoded = decodeChar(bitBuffer.toString());
                    if ((int) decoded == 26) { 
                        break;
                    }
                    writer.write(decoded);
                    bitBuffer.setLength(0); 
                }
            }

        } catch (IOException e) {
            System.err.println("I/O error during decoding: " + e.getMessage());
        }
    }

}