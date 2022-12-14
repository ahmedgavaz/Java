import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Merge_Two_Files {
    public static void main(String[] args) throws IOException {
        String pathFirst ="D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathSecond = "D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String pathThird = "D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputThree.txt";
        List<String> first = Files.readAllLines(Path.of(pathFirst));
        List<String> second = Files.readAllLines(Path.of(pathSecond));
        PrintWriter pr = new PrintWriter(pathThird);
        for (String line:first) {
            pr.println(line);
        }for (String line:second) {
            pr.println(line);
        }
        pr.close();
    }
}
