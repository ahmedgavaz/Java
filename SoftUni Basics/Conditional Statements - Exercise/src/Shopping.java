import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget =Double.parseDouble(scanner.nextLine());
        int videocards = Integer.parseInt(scanner.nextLine());
        int processors = Integer.parseInt(scanner.nextLine());
        int ram = Integer.parseInt(scanner.nextLine());
        double priceVideocards = videocards * 250;
        double priceProcessor = (priceVideocards * 0.35) * processors;
        double priceRAM = (priceVideocards * 0.1) * ram;
        double sum = priceProcessor + priceRAM + priceVideocards;
        if (videocards > processors){
            sum = sum * 0.85;
        }
        double x = Math.abs(sum - budget);
        if (budget >= sum){
            System.out.printf("You have %.2f leva left!",x);
        }
        else System.out.printf("Not enough money! You need %.2f leva more!",x);
    }
}
