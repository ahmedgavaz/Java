import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int orders = Integer.parseInt(scanner.nextLine());
        double sum=0;
        for (int i = 0; i < orders; i++) {
            double price = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsules = Integer.parseInt(scanner.nextLine());
            sum+=price*days*capsules;
            System.out.printf("The price for the coffee is: $%.2f%n",price*days*capsules);
        }
        System.out.printf("Total: $%.2f",sum);
    }
}
