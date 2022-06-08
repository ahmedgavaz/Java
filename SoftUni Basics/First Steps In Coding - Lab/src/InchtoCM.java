import java.util.Scanner;

public class InchtoCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println(a*2.54);
    }
}
