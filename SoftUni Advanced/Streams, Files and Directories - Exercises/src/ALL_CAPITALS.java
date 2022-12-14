import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

public class ALL_CAPITALS {
    public static void main(String[] args) throws IOException {
        Path pathRead = Paths.get("D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        Path pathWrite = Paths.get("D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        BufferedWriter bw = Files.newBufferedWriter(pathWrite);
        List<String> lines = Files.readAllLines(pathRead);
        for (String line:lines) {
            line = line.toUpperCase();
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }
}
