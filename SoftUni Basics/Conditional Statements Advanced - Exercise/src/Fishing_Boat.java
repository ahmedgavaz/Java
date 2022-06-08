import java.util.Scanner;

public class Fishing_Boat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());

        //"Spring", "Summer", "Autumn", "Winter"
        double boatPrice = 0;
        switch (season) {
            case "Spring":
                boatPrice = 3000;
                break;
            case "Summer":
            case "Autumn":
                boatPrice = 4200;
                break;
            case "Winter":
                boatPrice = 2600;
                break;
        }

        if (people <= 6) {
            boatPrice = boatPrice * 0.90;
        } else if (people <= 11) {
            boatPrice = boatPrice * 0.85;
        } else {
            boatPrice = boatPrice * 0.75;
        }

        if (people % 2 == 0 && !season.equals("Autumn")) {
            boatPrice = boatPrice * 0.95;
        }

        double diff = Math.abs(budget - boatPrice);
        if (budget >= boatPrice) {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }
    }
}