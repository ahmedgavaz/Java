import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Sum_Lines {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> lines =Files.readAllLines(path);
        for (String line:lines) {
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                sum+=line.charAt(i);
            }
            System.out.println(sum);
            sum=0;
        }
    }
}
