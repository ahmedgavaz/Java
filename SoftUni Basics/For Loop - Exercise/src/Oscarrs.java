import java.util.Scanner;

public class Oscarrs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        double points = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String name1 = scanner.nextLine();
            double points1 = Double.parseDouble(scanner.nextLine());
            points += (points1 * name1.length()) / 2.0;
            if (points > 1250.5){
                i = n;
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!",name,points);
            }
        }
        if (points <= 1250.5){
            System.out.printf("Sorry, %s you need %.1f more!", name, (1250.5 - points));
        }
    }
}
