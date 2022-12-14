import java.util.Scanner;

public class Centuries_to_Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short century = Short.parseShort(scanner.nextLine());
        int years = century * 100;
        double days = years * 365.2422;
        double hours = days * 24;
        double minutes = hours * 60;
        System.out.printf("%d centuries = %d years = %.0f days = %.0f hours = %.0f minutes",century,years,days,hours,minutes);
    }
}
