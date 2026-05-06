import java.io.IOException;

public class HuffmanTester {
    public static void main(String[] args) throws IOException {

        HuffmanCodeGenerator generator = new HuffmanCodeGenerator("text.txt");
        generator.makeCodeFile("dictionary.txt");

        HuffmanEncoder encoder = new HuffmanEncoder("dictionary.txt");
        encoder.encodeFileToHuffmanCodes("text.txt", "encoded.txt");

        HuffmanDecoder decoder = new HuffmanDecoder("dictionary.txt");
        decoder.decodeFileFromHuffmanCodes("encoded.txt", "decoded.txt");

        System.out.println("\n---terminé---\n");

    }
}
