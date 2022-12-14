import java.util.Scanner;

public class Vending_Machine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (true) {
            String coin = scanner.nextLine();
            if (!(coin.equals("Start"))) {
                double coins = Double.parseDouble(coin);
                if (coins != 0.1 && coins != 0.2 && coins != 0.5 && coins != 1 && coins != 2) {
                    System.out.printf("Cannot accept %.2f%n", coins);
                } else sum += coins;
            } else {
                break;
            }
        }
        while (true) {
            String product = scanner.nextLine();
            if (!(product.equals("End"))) {
                switch (product){
                    case "Nuts":
                        if (sum>=2){
                            System.out.println("Purchased Nuts");
                            sum=sum-2;
                        }
                        else{
                            System.out.println("Sorry, not enough money");
                        }
                        break;
                    case "Water":
                        if (sum>=0.7){
                            System.out.println("Purchased Water");
                            sum=sum-0.7;
                        }
                        else{
                            System.out.println("Sorry, not enough money");
                        }
                        break;
                    case "Crisps":
                        if (sum>=1.5){
                            System.out.println("Purchased Crisps");
                            sum=sum-1.5;
                        }
                        else{
                            System.out.println("Sorry, not enough money");
                        }
                        break;
                    case "Soda":
                        if (sum>=0.8){
                            System.out.println("Purchased Soda");
                            sum=sum-0.8;
                        }
                        else{
                            System.out.println("Sorry, not enough money");
                        }
                        break;
                    case "Coke":
                        if (sum>=1){
                            System.out.println("Purchased Coke");
                            sum=sum-1;
                        }
                        else{
                            System.out.println("Sorry, not enough money");
                        }
                        break;
                    default:
                        System.out.println("Invalid product");
                        break;
                }
            } else {
                break;
            }
        }
        System.out.printf("Change: %.2f",sum);
    }
}
