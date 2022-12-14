import java.util.List;
import java.util.Scanner;

public class Digits_Letters_and_Other {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))){
                digits.append(text.charAt(i));
            }
            else if (Character.isLetter(text.charAt(i))){
                letters.append(text.charAt(i));
            }
            else {
                other.append(text.charAt(i));
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(other);
    }
}
