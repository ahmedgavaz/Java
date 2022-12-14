import java.util.Scanner;

public class Even_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num % 2 == 0) {
                System.out.printf("The number is: %d",Math.abs(num));
                break;
            } else {
                System.out.println("Please write an even number.");
            }
        }
    }
}
