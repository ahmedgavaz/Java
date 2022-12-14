import java.text.DecimalFormat;
import java.util.Scanner;

public class The_Hunting_Games {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int players = Integer.parseInt(scanner.nextLine());
        double energy = Double.parseDouble(scanner.nextLine());
        double water = Double.parseDouble(scanner.nextLine()) * players * days;
        double food = Double.parseDouble(scanner.nextLine()) * players * days;
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 1; i <= days; i++) {
            double energyLoss = Double.parseDouble(scanner.nextLine());
            energy -= energyLoss;
            if (energy <= 0) {
                System.out.println("You will run out of energy. You will be left with " + df.format(food) + " food and " + df.format(water) + " water.");
                return;
            }
            if (i % 2 == 0) {
                energy *= 1.05;
                water *= 0.7;
            }
            if (i % 3 == 0) {
                food = food - food / players;
                energy *= 1.1;
            }
        }
        System.out.println("You are ready for the quest. You will be left with - " + df.format(energy) + " energy!");
    }
}
