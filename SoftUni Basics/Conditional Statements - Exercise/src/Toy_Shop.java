import java.util.Scanner;

public class Toy_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double price = Double.parseDouble(scanner.nextLine());
        int puzzle = Integer.parseInt(scanner.nextLine());
        int doll = Integer.parseInt(scanner.nextLine());
        int bear = Integer.parseInt(scanner.nextLine());
        int miner = Integer.parseInt(scanner.nextLine());
        int truck = Integer.parseInt(scanner.nextLine());
        double sum = puzzle * 2.6 + doll * 3 + bear * 4.1 + miner * 8.2 + truck * 2;
        if (puzzle + doll + bear + miner + truck >= 50){
            sum = sum * 0.75;
        }
        sum = sum * 0.9;
        double x = Math.abs(sum - price);
        if (sum >= price){
            System.out.printf("Yes! %.2f lv left.",x);
        }
        else System.out.printf("Not enough money! %.2f lv needed.",x);
    }
}
