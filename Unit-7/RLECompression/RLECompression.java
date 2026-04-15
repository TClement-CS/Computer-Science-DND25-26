import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class RLECompression {

    // Creates a compressed version with fileName + ".rle.bw"
    public static void compress(String fileName) throws IOException {
        bwTransform(fileName);
        encode(fileName + ".bw");
    }

    // Decompresses a .rle.bw file
    public static void decompress(String fileName) throws IOException {
        decode(fileName);
        invertBWTransform(fileName.substring(0, fileName.length() - 4));
    }

    // Encodes the contents of a file using the RLE compression scheme:
    // single characters are left alone, and runs of 2+ characters are encoded as
    // that letter twice, followed by the length of the run, cast as a char
    public static void encode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(fileName + ".rle");

        char previousChar = (char) br.read();
        int count = 1;

        while (br.ready()) {
            char c = (char) br.read();
            // TO-DO
            // Now here: do things with the char you just read, dependent on the char you
            // just read
            if (c == previousChar) {
                count++;
            } else {
                if (count > 1) {
                    pw.write("" + previousChar + previousChar + count);
                    // pw.write( the last char in the file);
                } else {
                    pw.write(previousChar);
                }
                previousChar = c;
                count = 1;
            }
        }
        if (count > 1) {
            pw.write("" + previousChar + previousChar + count);
        } else {
            pw.write(previousChar);
        }
        br.close();
        pw.close();
    }

    // Decodes the above scheme
    public static void decode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(fileName.substring(0, fileName.length() - 4));

        char previousChar = (char) br.read();

        while (br.ready()) {
            char c = (char) br.read();
            // TO-DO
            // Now here: do things with the char you just read, dependent on the char you
            // just read
            StringBuilder num = new StringBuilder();
            while (br.ready()) {
                br.mark(1);
                char next = (char) br.read();
                if (Character.isDigit(next)) {
                    num.append(next);
                } else {
                    break;
                }
            }
            int count = num.length() == 0 ? 1 : Integer.parseInt(num.toString());
            for (int i = 0; i < count; i++) {
                pw.write(c);
            }
        }
        br.close();
        pw.close();
    }

    public static void bwTransform(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        // Add a null character at the beginning, as a
        // "beginning of file" character
        StringBuilder originalText = new StringBuilder("" + '\0');

        while (br.ready()) {
            char c = (char) br.read();
            originalText.append(c);
        }
        br.close();

        String[] rotations = new String[originalText.length()];
        rotations[0] = originalText.toString();
        // TO-DO
        // Now do the Burrows-Wheeler Transform
        for (int i = 1; i < rotations.length; i++) {
            rotations[i] = originalText.substring(i) + originalText.substring(0, i);
        }
        Arrays.sort(rotations);
        StringBuilder bwt = new StringBuilder();
        for (String s : rotations) {
            bwt.append(s.charAt(s.length() - 1));
        }
        PrintWriter pw = new PrintWriter(fileName + ".bw");
        pw.write(bwt.toString());
        pw.close();
    }

    public static void invertBWTransform(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        StringBuilder originalText = new StringBuilder();

        while (br.ready()) {
            char c = (char) br.read();
            originalText.append(c);
        }
        br.close();

        StringBuilder[] reconstructions = new StringBuilder[originalText.length()];
        for (int i = 0; i < reconstructions.length; i++) {
            reconstructions[i] = new StringBuilder("" + originalText.charAt(i));
        }
        // TO-DO
        // Now undo the Burrows-Wheeler transform
        int n = originalText.length();
        String[] table = new String[n];
        for (int i = 0; i < n; i++) {
            table[i] = "";
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[j] = originalText.charAt(j) + table[j];
            }
            Arrays.sort(table);
        }
        String result = "";
        for (int i = 0; i < n; i++) {
            if (table[i].indexOf('\0') != -1) {
                result = table[i];
                break;
            }
        }
        int idx = result.indexOf('\0');
        if (idx != -1) {
            result = result.substring(0, idx) + result.substring(idx + 1);
        }

        // TO-DO
        // And write the appropriate reconstruction into the file, without the null char
        PrintWriter pw = new PrintWriter(fileName.substring(0, fileName.length() - 3));
        pw.write(result);
        pw.close();
    }
}
