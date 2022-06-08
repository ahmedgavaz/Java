import java.util.Scanner;

public class Deer_of_Santa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int food = Integer.parseInt(scanner.nextLine());
        double foodPerDay1 = Double.parseDouble(scanner.nextLine());
        double foodPerDay2 = Double.parseDouble(scanner.nextLine());
        double foodPerDay3 = Double.parseDouble(scanner.nextLine());
        double totalFood = days * (foodPerDay1 + foodPerDay2 + foodPerDay3);
        if (totalFood <= food) {
            System.out.printf("%.0f kilos of food left.", Math.floor(food - totalFood));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(totalFood - food));
        }
    }
}
