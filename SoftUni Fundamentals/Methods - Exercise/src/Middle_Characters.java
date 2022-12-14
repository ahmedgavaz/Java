import java.util.Scanner;

public class Middle_Characters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        middle(words);
    }
    public static void middle(String words){
        if (words.length()%2==0){
            System.out.printf("%c%c",words.charAt(words.length()/2-1),words.charAt(words.length()/2));
        }
        else {
            System.out.printf("%c",words.charAt(words.length()/2));
        }
    }
}
