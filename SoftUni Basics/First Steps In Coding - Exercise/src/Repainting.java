import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nylon = Integer.parseInt(scanner.nextLine());
        int paint =Integer.parseInt(scanner.nextLine());
        int razred = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());
        double sum = (nylon+2) * 1.5 + paint * 1.1 * 14.5 + razred * 5 + 0.4;
        double hourPay = sum*0.3;
        double totalSum = sum + hourPay * hours;
        System.out.println(totalSum);
    }
}
