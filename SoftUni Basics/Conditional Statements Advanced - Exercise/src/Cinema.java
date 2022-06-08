import javax.management.InstanceNotFoundException;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        if (type.equals("Premiere")){
            sum = sum + 12 * r * c;
        }else if (type.equals("Normal")){
            sum = sum + 7.5 * r *c;
        }else sum = sum + 5 * r * c;
        System.out.printf("%.2f",sum);
    }
}
