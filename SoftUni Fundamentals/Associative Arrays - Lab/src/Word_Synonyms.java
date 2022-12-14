import java.util.*;

public class Word_Synonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> synonymList = new LinkedHashMap<>();
        int n =Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String word1 = scanner.nextLine();
            String word2 = scanner.nextLine();
            if (synonymList.containsKey(word1)){
                synonymList.get(word1).add(word2);
            }
            else{
                synonymList.put(word1, new ArrayList<>());
                synonymList.get(word1).add(word2);
            }
        }
        for(Map.Entry<String, List<String>> elem:synonymList.entrySet()){
            System.out.printf("%s - %s%n",elem.getKey(),String.join(", ", elem.getValue()));}
    }
}
