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
            String line = "";
            while ((line = reader.readLine()) != null) { // before lines 15-22 were storing encoded values as "a:110",
                                                         // now it stores it as "110"
                if (!line.isEmpty()) {
                    String[] parts = line.split(":", 2);
                    if (parts.length == 2) {
                        char c = parts[0].charAt(0);
                        String code = parts[1];
                        codeMap.put(c, code);
                    }
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

    public void encodeFile(String fileToCompress) {

        StringBuilder encodedBits = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileToCompress))) {

            int temp;
            while ((temp = reader.read()) != -1) {
                encodedBits.append(encodeChar((char) temp));
            }

            encodedBits.append(encodeChar((char) 26));

        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
            return;
        }
        while (encodedBits.length() % 8 != 0) {
            encodedBits.append('0');
        }
        String outputFile = fileToCompress + ".huf";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            for (int i = 0; i < encodedBits.length(); i += 8) {
                String byteString = encodedBits.substring(i, i + 8);
                int value = Integer.parseInt(byteString, 2);
                writer.write((char) value);
            }

        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
