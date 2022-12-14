import java.util.Scanner;

public class Chars_to_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char sign1 = scanner.nextLine().charAt(0);
        char sign2 = scanner.nextLine().charAt(0);
        char sign3 = scanner.nextLine().charAt(0);
        System.out.println(""+sign1+sign2+sign3);
    }
}
