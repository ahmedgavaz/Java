import java.util.Scanner;

public class Number_in_Range {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        if (a >= -100 && a <= 100 && a != 0) {
            System.out.println("Yes");
        }
        else System.out.println("No");
    }
}
