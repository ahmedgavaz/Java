import java.util.Scanner;

public class Supplies_For_School {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pen = Integer.parseInt(scanner.nextLine());
        int marker =Integer.parseInt(scanner.nextLine());
        int liters =Integer.parseInt(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());
        double sum = (pen * 5.8 + marker * 7.2 + liters * 1.2)*(100 - percent)*0.01;
        System.out.println(sum);
    }

}
