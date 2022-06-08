import java.util.Scanner;

public class Excursion_Sale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberSea = Integer.parseInt(scanner.nextLine());
        int numberMountain = Integer.parseInt(scanner.nextLine());
        int total = 0;
        String paket = scanner.nextLine();
        while (!paket.equals("Stop")) {
            if (paket.equals("sea") && numberSea > 0) {
                total += 680;
                numberSea--;
            }
            if (paket.equals("mountain") && numberMountain > 0) {
                total += 499;
                numberMountain--;
            }
            if (numberMountain == 0 && numberSea == 0) {
                break;
            }
            paket = scanner.nextLine();
        }
        if (numberMountain == 0 && numberSea == 0) {
            System.out.println("Good job! Everything is sold.");
        }
        System.out.printf("Profit: %d leva.", total);
    }
}
