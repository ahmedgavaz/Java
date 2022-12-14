import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Count_Symbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character,Integer> characters = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            char sign = text.charAt(i);
            if (characters.containsKey(sign)){
                characters.put(sign,characters.get(sign)+1);
            }else{
                characters.put(sign,1);
            }
        }
        characters.entrySet().forEach(e-> System.out.printf("%c: %d time/s%n",e.getKey(),e.getValue()));
    }
}
