import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException{
        //AAAABBCCAAS
        System.out.println("Compression");
        RLECompression.compress("test.txt");
        System.out.println("Decompression");
        RLECompression.decompress("test.txt.bw.rle");
    }
}
