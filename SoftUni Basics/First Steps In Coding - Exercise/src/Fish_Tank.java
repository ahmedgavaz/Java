import java.util.Scanner;

public class Fish_Tank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());
        double totalWater = length * width * height *0.001;
        double total = totalWater * (100-percent) * 0.01;
        System.out.println(total);
    }
}
