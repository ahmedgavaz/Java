import java.util.Scanner;

public class Clever_Lily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        int r = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        int toys = 0;
        int money = 10;
        for (int i = 1; i <= n; i++){
            if (i % 2 ==1){
                toys ++;
            }else {
                sum += money;
                money += 10;
            }
        }
        sum = (sum - n / 2) + (toys * r);
        if (sum >= price) {
            System.out.printf("Yes! %.2f", sum - price);
        }else System.out.printf("No! %.2f", price - sum);
    }
}
