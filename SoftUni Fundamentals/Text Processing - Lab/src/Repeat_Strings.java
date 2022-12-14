import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repeat_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        for (String word:words) {
            String repeated =word.repeat(word.length());
            System.out.print(repeated);
        }
    }
    /*public static String repeat(String word,int count){
        String[] repeated= new String[count];
        for (int i = 0; i < count; i++) {
            repeated[i]=word;
        }
        return String.join("",repeated);
    }*/
}
