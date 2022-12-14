import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Sum_Bytes {
    public static void main(String[] args) throws IOException {
        long sum =0;
        Path path = Paths.get("D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> lines = Files.readAllLines(path);
        for (String line:lines) {
            for (int i = 0; i < line.length(); i++) {
                sum+=line.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
