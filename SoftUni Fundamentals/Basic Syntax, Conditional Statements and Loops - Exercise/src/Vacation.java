import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String person = scanner.nextLine();
        String day = scanner.nextLine();
        if (day.equals("Friday")) {
            if (person.equals("Students")) {
                if (number >= 30) {
                    System.out.printf("Total price: %.02f", number * 8.45 * 0.85);
                } else {
                    System.out.printf("Total price: %.02f", number * 8.45);
                }
            } else if (person.equals("Business")) {
                if (number >= 100) {
                    System.out.printf("Total price: %.02f", (number - 10) * 10.9);
                } else {
                    System.out.printf("Total price: %.02f", number * 10.9);
                }
            } else if (person.equals("Regular")) {
                if (number >= 10 && number <= 20) {
                    System.out.printf("Total price: %.02f", number * 15 * 0.95);
                } else {
                    System.out.printf("Total price: %.02f", 1.0 * number * 15);
                }
            }
        } else if (day.equals("Saturday")) {
            if (person.equals("Students")) {
                if (number >= 30) {
                    System.out.printf("Total price: %.02f", number * 9.8 * 0.85);
                } else {
                    System.out.printf("Total price: %.02f", number * 9.8);
                }
            } else if (person.equals("Business")) {
                if (number >= 100) {
                    System.out.printf("Total price: %.02f", (number - 10) * 15.6);
                } else {
                    System.out.printf("Total price: %.02f", number * 15.6);
                }
            } else if (person.equals("Regular")) {
                if (number >= 10 && number <= 20) {
                    System.out.printf("Total price: %.02f", number * 20 * 0.95);
                } else {
                    System.out.printf("Total price: %.02f", 1.0 * number * 20);
                }
            }
        } else if (day.equals("Sunday")) {
            if (person.equals("Students")) {
                if (number >= 30) {
                    System.out.printf("Total price: %.02f", number * 10.46 * 0.85);
                } else {
                    System.out.printf("Total price: %.02f", number * 10.46);
                }
            } else if (person.equals("Business")) {
                if (number >= 100) {
                    System.out.printf("Total price: %.02f", 1.0 * (number - 10) * 16);
                } else {
                    System.out.printf("Total price: %.02f", 1.0 * number * 16);
                }
            } else if (person.equals("Regular")) {
                if (number >= 10 && number <= 20) {
                    System.out.printf("Total price: %.02f", number * 22.5 * 0.95);
                } else {
                    System.out.printf("Total price: %.02f", number * 22.5);
                }
            }
        }
    }
}
