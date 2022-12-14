import java.lang.reflect.Array;
import java.util.*;

public class Odd_Occurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> wordsList = new LinkedHashMap<>();
        String[] lineWords = scanner.nextLine().toLowerCase(Locale.ROOT).split(" ");
        for (int i = 0; i < lineWords.length; i++) {
            wordsList.putIfAbsent(lineWords[i],0);
            wordsList.put(lineWords[i],wordsList.get(lineWords[i])+1);
        }
        List<String> listOutput = new ArrayList<>();
        for (Map.Entry<String,Integer> elem:wordsList.entrySet()) {
            if(elem.getValue()%2==1){
                listOutput.add(elem.getKey());
            }
        }
        for (int i = 0; i < listOutput.size()-1; i++) {
            System.out.printf("%s, ",listOutput.get(i));
        }
        System.out.printf("%s",listOutput.get(listOutput.size()-1));
    }
}
