import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Count_Chars_in_a_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String charsHolder = scanner.nextLine();
        Map<Character,Integer> listCounter = new LinkedHashMap<>();
        for (int i = 0; i < charsHolder.length(); i++) {
            if (charsHolder.charAt(i)!=' '){
                listCounter.putIfAbsent(charsHolder.charAt(i),0);
                listCounter.put(charsHolder.charAt(i),listCounter.get(charsHolder.charAt(i))+1);
            }
        }
        for(Map.Entry<Character,Integer> elem:listCounter.entrySet()){
            System.out.printf("%s -> %d%n",elem.getKey(),elem.getValue());
        }
    }
}
