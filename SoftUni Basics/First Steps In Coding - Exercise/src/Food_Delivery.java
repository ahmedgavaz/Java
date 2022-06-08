import java.util.Scanner;

public class Food_Delivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chicken = Integer.parseInt(scanner.nextLine());
        int fish = Integer.parseInt(scanner.nextLine());
        int vegan = Integer.parseInt(scanner.nextLine());
        double sum = chicken * 10.35 + fish * 12.4 + vegan * 8.15;
        double desert = sum * 0.2;
        double totalSum= desert + sum + 2.5;
        System.out.println(totalSum);
    }
}
