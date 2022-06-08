import java.util.Scanner;

public class Sum_seconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int sum = a + b + c;
        if (sum % 60 >= 10) {
            System.out.printf("%d:%d", sum / 60, sum % 60);
        }
        else System.out.printf("%d:0%d", sum / 60, sum % 60);
    }
}
