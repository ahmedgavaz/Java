import java.util.Random;
import java.util.Scanner;

public class Randomize_Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        Random rnd = new Random();
        for (int i = 0; i < words.length; i++) {
            int x= rnd.nextInt(words.length);
            String temp = words[i];
            words[i] = words[x];
            words[x] = temp;
        }
        System.out.println(String.join(System.lineSeparator(),words));
    }
}
