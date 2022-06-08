import java.util.Scanner;

public class Invalid_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        if ((a >= 100 && a <= 200) || a ==0) {
            System.out.println("");
        }else System.out.println("invalid");
    }
}
