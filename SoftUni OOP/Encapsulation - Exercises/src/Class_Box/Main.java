package Class_Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());
        Box box = new Box(a,b,c);
        System.out.printf("Surface Area - %.2f%n",box.calculateSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n",box.calculateLateralSurfaceArea());
        System.out.printf("Volume - %.2f",box.calculateVolume());
    }
}
