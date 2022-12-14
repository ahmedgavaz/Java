import java.util.Scanner;

public class Characters_in_Range {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        characters(first, second);
    }

    public static void characters(char first, char second) {
        if (first < second) {
            for (int i = first + 1; i < second; i++) {
                System.out.printf("%c ", i);
            }
        } else {
            for (int i = second + 1; i < first; i++) {
                System.out.printf("%c ", i);
            }
        }
    }
}
