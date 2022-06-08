import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        String typeNight = "";
        double sum = 0;
        if (budget <= 100) {
            destination = "Bulgaria";
            if (season.equals("summer")) {
                sum = budget * 0.30;
                typeNight = "Camp";
            } else if (season.equals("winter")) {
                sum = budget * 0.70;
                typeNight = "Hotel";
            }
        } else if (budget <= 1000) {
            destination = "Balkans";
            if (season.equals("summer")) {
                sum = budget * 0.40;
                typeNight = "Camp";
            } else if (season.equals("winter")) {
                sum = budget * 0.80;
                typeNight = "Hotel";
            }
        } else {
            destination = "Europe";
            sum = budget * 0.90;
            typeNight = "Hotel";
        }

        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", typeNight, sum);
    }
}