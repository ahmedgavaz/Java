import java.util.Scanner;

public class USD_To_BGN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double usd = Double.parseDouble(scanner.nextLine());
        double bg = usd * 1.79549;
        System.out.println(bg);
    }
}
