import java.util.Scanner;

public class Convert_Meters_To_Kilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meters = Integer.parseInt(scanner.nextLine());
        System.out.printf("%.2f",meters/1000.0);
    }
}
