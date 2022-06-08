import java.util.Scanner;

public class Final_Competition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dancers = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();
        double totalMoney = 0;
        if (place.equals("Bulgaria")) {
            if (season.equals("summer")) {
                totalMoney = dancers * points * 0.95;
            } else {
                totalMoney = dancers * points * 0.92;
            }
        } else {
            if (season.equals("summer")) {
                totalMoney = dancers * points * 1.5 * 0.9;
            } else {
                totalMoney = dancers * points * 1.5 * 0.85;
            }
        }
        System.out.printf("Charity - %.2f%n", totalMoney * 0.75);
        System.out.printf("Money per dancer - %.2f", ((totalMoney * 0.25) / dancers));
    }
}
