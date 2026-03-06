import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadLines {
    public static List<String> readAllLines(Path file) throws IOException {
        // Each element is one line from the file
        return Files.readAllLines(file);
    }
}
