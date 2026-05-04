import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class HuffmanEncoder {

    private final HashMap<Character, String> codeMap = new HashMap<>();

    public HuffmanEncoder(String codeFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(codeFile))) {
            for (int i = 0; i < 128; i++) {
                String line = reader.readLine();
                if (line != null && !line.isEmpty()) {
                    codeMap.put((char) i, line);
                }
            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred:" + e.getMessage());
        }
    }

    public String encodeChar(char input) {
        if (codeMap.containsKey(input)) {
            return codeMap.get(input);
        } else {
            return "";
        }
    }

    public void encodeFileToHuffmanCodes(String input, String studentOutput) {

        StringBuilder encodedBits = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            int temp = 0;
            while ((temp = reader.read()) != -1) {
                encodedBits.append(encodeChar((char) temp));
            }
            encodedBits.append(encodeChar((char) 26));
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            return;
        }

        while (encodedBits.length() % 8 != 0) {
            encodedBits.append('0');
        }

        File outputFile = new File(studentOutput);
        try {
            if (!outputFile.exists()) {
                outputFile.createNewFile(); 
            }
        } catch (IOException e) {
            System.err.println("Error creating output file: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(encodedBits.toString());
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }

}
