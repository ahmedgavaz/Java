import java.util.Scanner;

public class Godzilla_VS_Kong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget =Double.parseDouble(scanner.nextLine());
        int number = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        double decor = budget * 0.1;
        if (number > 150) {
            price = price * 0.9;
        }
        double sum = decor + price * number;
        double x = Math.abs(budget - sum);
        if (budget >= sum){
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.",x);
        }
        else {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.",x);
        }
    }
}
