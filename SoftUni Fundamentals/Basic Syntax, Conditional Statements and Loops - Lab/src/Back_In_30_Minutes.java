import java.util.Scanner;

public class Back_In_30_Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minute = Integer.parseInt(scanner.nextLine());
        int sum = hour * 60 + minute + 30;
        if (sum / 60 > 23) {
            System.out.printf("0:%02d", sum % 60);
        } else {
            System.out.printf("%d:%02d", sum / 60, sum % 60);
        }
    }
}
