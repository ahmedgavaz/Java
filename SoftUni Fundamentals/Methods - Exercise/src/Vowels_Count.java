import java.util.Scanner;

public class Vowels_Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        vowels(words);
    }
    public static void vowels(String words){
        int count=0;
        words = words.toLowerCase();
        for (char letter:words.toCharArray()) {
            if (letter=='a' || letter=='o' || letter=='u' || letter=='e' || letter=='i'){
                count++;
            }
        }
        System.out.println(count);
    }
}
