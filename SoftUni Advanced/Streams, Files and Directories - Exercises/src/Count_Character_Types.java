import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Count_Character_Types {
    public static void main(String[] args) throws IOException {
        String pathRead = "D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String pathWrite = "D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output_4.Exercise.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathWrite));
        List<String> lines = Files.readAllLines(Path.of(pathRead));
        int countVowels = 0;
        int countConstant = 0;
        int countPunctuation = 0;
        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch==' '){
                    continue;
                }
                else if ((ch == 'a') || (ch == 'o') || (ch == 'e') || (ch == 'i') || (ch == 'u')) {
                    countVowels++;
                } else if (ch == ',' || ch == '.' || ch == '!' || ch == '?') {
                    countPunctuation++;
                }else {
                    countConstant++;
                }
            }
        }
        bw.write("Vowels: "+countVowels);
        bw.newLine();
        bw.write("Consonants: "+countConstant);
        bw.newLine();
        bw.write("Punctuation: "+countPunctuation);
        bw.close();
    }
}
