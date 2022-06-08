import java.util.Scanner;

public class Small_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double price = 0;
        switch (city) {
            case "Sofia":
                switch (product) {
                    case "coffee":
                        price = price + quantity * 0.5;
                        break;
                    case "water":
                        price = price + quantity * 0.8;
                        break;
                    case "beer":
                        price = price + quantity * 1.2;
                        break;
                    case "sweets":
                        price = price + quantity * 1.45;
                        break;
                    case "peanuts":
                        price = price + quantity * 1.6;
                        break;
                }
                break;
            case "Plovdiv":
                switch (product) {
                    case "coffee":
                        price = price + quantity * 0.4;
                        break;
                    case "water":
                        price = price + quantity * 0.7;
                        break;
                    case "beer":
                        price = price + quantity * 1.15;
                        break;
                    case "sweets":
                        price = price + quantity * 1.3;
                        break;
                    case "peanuts":
                        price = price + quantity * 1.50;
                        break;
                }
                break;
            case "Varna":
                switch (product) {
                    case "coffee":
                        price = price + quantity * 0.45;
                        break;
                    case "water":
                        price = price + quantity * 0.7;
                        break;
                    case "beer":
                        price = price + quantity * 1.1;
                        break;
                    case "sweets":
                        price = price + quantity * 1.35;
                        break;
                    case "peanuts":
                        price = price + quantity * 1.55;
                        break;
                }
                break;
        }
        System.out.println(price);
    }
}
