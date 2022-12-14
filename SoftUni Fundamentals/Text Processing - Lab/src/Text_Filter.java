import java.util.Scanner;

public class Text_Filter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String word:words) {
            while (text.contains(word)){
                String s="*";
                text = text.replace(word,s.repeat(word.length()));
            }
        }
        System.out.println(text);
    }
}
