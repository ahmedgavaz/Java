import java.util.Scanner;

public class Account_Balance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        String text = scanner.nextLine();
        while (!text.equals("NoMoreMoney")){
            double money = Double.parseDouble(text);
            if (money >= 0) {
                System.out.printf("Increase: %.2f%n",money);
                sum += money;
            }
            else {
                System.out.println("Invalid operation!");
                break;
            }
            text = scanner.nextLine();
        }
        System.out.printf("Total: %.2f",sum);
    }
}
