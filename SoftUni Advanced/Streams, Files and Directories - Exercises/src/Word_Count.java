import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Word_Count {
    public static void main(String[] args) throws IOException {
        String pathWords = "D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathRead = "D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String pathWrite = "D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";
        Map<String,Integer> wordsCount = new LinkedHashMap<>();
        List<String> words = Files.readAllLines(Path.of(pathWords));
        PrintWriter pw = new PrintWriter(pathWrite);
        for (String word:words) {
            String wordsOfLine[] = word.split("\\s+");
            for (String wor:wordsOfLine) {
                wordsCount.put(wor,0);
            }
        }
        BufferedReader br = new BufferedReader(new FileReader(pathRead));
        String lines = br.readLine();
        while (lines!=null){
            String[] line = lines.split("\\s+");
            for (String consist:line) {
                if (wordsCount.containsKey(consist)){
                    wordsCount.put(consist,wordsCount.get(consist)+1);
                }
            }
            lines= br.readLine();
        }
        wordsCount.entrySet().stream().sorted((e1,e2)->{
            int i = e2.getValue() - e1.getValue();
            return i;
        }).forEach(entry->{
            pw.println(entry.getKey()+" - "+ entry.getValue());
        });
      /*  for (Map.Entry<String,Integer> entry:wordsCount.entrySet()) {
            pw.println(entry.getKey()+" - "+ entry.getValue());
        }*/
        pw.close();
    }
}
