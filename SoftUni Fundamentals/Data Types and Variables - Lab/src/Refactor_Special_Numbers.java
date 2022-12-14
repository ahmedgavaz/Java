import java.util.Scanner;
public class Refactor_Special_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        boolean isSpecial = false;
        for (int num = 1;num <= number; num++) {
            int suma = 0;
            int numberCheck = num;
            while (numberCheck > 0) {
                suma += numberCheck % 10;
                numberCheck = numberCheck / 10;
            }
            if ((suma == 5) ||(suma == 7) || (suma == 11)) {
                System.out.printf("%d -> True%n", num);
            }else
                System.out.printf("%d -> False%n", num);
        }
    }
}
