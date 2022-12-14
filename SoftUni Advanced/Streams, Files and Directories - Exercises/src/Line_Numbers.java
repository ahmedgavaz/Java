import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Line_Numbers {
    public static void main(String[] args) throws IOException {
        String pathRead = "D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String pathWrite = "D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputLineNumbers.txt";
        List<String> lines = Files.readAllLines(Path.of(pathRead));
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathWrite));
        int count =1;
        for (String line:lines) {
            bw.write(count+". "+line);
            bw.newLine();
            count++;
        }
        bw.close();
    }
}
