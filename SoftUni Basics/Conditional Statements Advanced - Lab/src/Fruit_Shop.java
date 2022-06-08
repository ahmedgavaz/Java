import java.util.Scanner;
import java.util.SortedMap;

public class Fruit_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double price = 0;
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                switch (fruit) {
                    case "banana":
                        price = price + quantity * 2.5;
                        System.out.printf("%.2f",price);
                        break;
                    case "apple":
                        price = price + quantity * 1.2;
                        System.out.printf("%.2f",price);
                        break;
                    case "orange":
                        price = price + quantity * 0.85;
                        System.out.printf("%.2f",price);
                        break;
                    case "grapefruit":
                        price = price + quantity * 1.45;
                        System.out.printf("%.2f",price);
                        break;
                    case "kiwi":
                        price = price + quantity * 2.7;
                        System.out.printf("%.2f",price);
                        break;
                    case "pineapple":
                        price = price + quantity * 5.5;
                        System.out.printf("%.2f",price);
                        break;
                    case "grapes":
                        price = price + quantity * 3.85;
                        System.out.printf("%.2f",price);
                        break;
                    default:
                        System.out.println("error");
                }
                break;
            case "Saturday":
            case "Sunday":
                switch (fruit) {
                    case "banana":
                        price = price + quantity * 2.7;
                        System.out.printf("%.2f",price);
                        break;
                    case "apple":
                        price = price + quantity * 1.25;
                        System.out.printf("%.2f",price);
                        break;
                    case "orange":
                        price = price + quantity * 0.9;
                        System.out.printf("%.2f",price);
                        break;
                    case "grapefruit":
                        price = price + quantity * 1.6;
                        System.out.printf("%.2f",price);
                        break;
                    case "kiwi":
                        price = price + quantity * 3;
                        System.out.printf("%.2f",price);
                        break;
                    case "pineapple":
                        price = price + quantity * 5.6;
                        System.out.printf("%.2f",price);
                        break;
                    case "grapes":
                        price = price + quantity * 4.2;
                        System.out.printf("%.2f",price);
                        break;
                    default:
                        System.out.println("error");
                }
                break;
                    default:
                        System.out.println("error");
        }
    }
}
