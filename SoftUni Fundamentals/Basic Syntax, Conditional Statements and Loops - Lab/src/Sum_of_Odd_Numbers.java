import java.util.Scanner;

public class Sum_of_Odd_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbebr = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i < numbebr * 2; i += 2) {
            System.out.println(i);
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }
}
