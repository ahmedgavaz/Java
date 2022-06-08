import java.util.Scanner;

public class Equal_Sums_Even_Odd_Position {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        for (int i = num1; i <= num2; i++) {
            int sum1 = 0;
            int sum2 = 0;
            String number = "" + i;
            for (int j = 0; j < number.length(); j++) {
                int a = Integer.parseInt("" + number.charAt(j));
                if (j % 2 == 0) {
                    sum1 = sum1 + a;
                } else sum2 = sum2 + a;
            }
            if (sum1 == sum2) {
                System.out.printf("%d ",i);
            }
        }
    }
}
