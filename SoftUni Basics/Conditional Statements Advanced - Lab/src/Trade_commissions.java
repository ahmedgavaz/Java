import java.util.Scanner;

public class Trade_commissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double price = 0;
        switch (city) {
            case "Sofia":
                if (quantity < 0){
                    System.out.println("error");
                }
                else if (quantity <= 500){
                    price = price + quantity*0.05;
                    System.out.printf("%.2f",price);
                }else if (quantity <= 1000){
                    price = price + quantity * 0.07;
                    System.out.printf("%.2f",price);
                }else if (quantity <= 10000){
                    price = price + quantity*0.08;
                    System.out.printf("%.2f",price);
                }else {
                    price = price + quantity * 0.12;
                    System.out.printf("%.2f",price);
                }
                break;
            case "Varna":
                if (quantity < 0){
                    System.out.println("error");
                }
                else if (quantity <= 500){
                    price = price + quantity*0.045;
                    System.out.printf("%.2f",price);
                }else if (quantity <= 1000){
                    price = price + quantity * 0.075;
                    System.out.printf("%.2f",price);
                }else if (quantity <= 10000){
                    price = price + quantity*0.1;
                    System.out.printf("%.2f",price);
                }else {
                    price = price + quantity * 0.13;
                    System.out.printf("%.2f",price);
                }
                break;
            case "Plovdiv":
                if (quantity < 0){
                    System.out.println("error");
                }
                else if (quantity <= 500){
                    price = price + quantity*0.055;
                    System.out.printf("%.2f",price);
                }else if (quantity <= 1000){
                    price = price + quantity * 0.08;
                    System.out.printf("%.2f",price);
                }else if (quantity <= 10000){
                    price = price + quantity*0.12;
                    System.out.printf("%.2f",price);
                }else {
                    price = price + quantity * 0.145;
                    System.out.printf("%.2f",price);
                }
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}
