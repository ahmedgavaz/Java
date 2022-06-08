import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int br = 0;
        int br1 = 1;
        double sr = 0;
        while (br < 2 && br1 <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade < 4) {
                br++;
                if (br == 2) {
                    break;
                }
            }
            sr = sr + grade;
            br1++;
        }
        if (br == 2) {
            System.out.printf("%s has been excluded at %d grade", name, br1 - 1);
        } else System.out.printf("%s graduated. Average grade: %.2f", name, sr / 12);
    }
}
