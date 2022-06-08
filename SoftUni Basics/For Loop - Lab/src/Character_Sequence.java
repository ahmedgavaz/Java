import java.util.Scanner;

public class Character_Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        for (int a = 0; a < text.length();a++)
            System.out.println(text.charAt(a));
    }
}
