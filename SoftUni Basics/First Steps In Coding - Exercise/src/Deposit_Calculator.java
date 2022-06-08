import java.util.Scanner;

public class Deposit_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double deposit = Double.parseDouble(scanner.nextLine());
        int period = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());
        double sum = deposit + period * ((deposit * percent*0.01)/12);
        System.out.println(sum);
    }
}
