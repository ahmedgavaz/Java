import java.util.Scanner;

public class Top_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number; i++) {
            if (sumDigits(i) && oddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        if (sum % 8==0) {
            return true;
        } else return false;
    }

    public static boolean oddDigit(int number) {
        while (number > 0) {
            if ((number / 10) % 2 == 1) {
                return true;
            }
            number = number / 10;
        }
        return false;
    }
}
