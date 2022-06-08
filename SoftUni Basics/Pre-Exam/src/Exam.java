import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        double total = 0;
        int under3 = 0;
        int under4 = 0;
        int under5 = 0;
        int under6 = 0;
        for (int i = 0; i < students; i++) {
            double evaluation = Double.parseDouble(scanner.nextLine());
            if (evaluation < 3 && evaluation >= 2) {
                under3++;
            } else if (evaluation < 4) {
                under4++;
            } else if (evaluation < 5) {
                under5++;
            } else if (evaluation >= 5) {
                under6++;
            }
            total += evaluation;
        }
        System.out.printf("Top students: %.2f%%%n", under6 * 1.0 / students * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", under5 * 1.0 / students * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", under4 * 1.0 / students * 100);
        System.out.printf("Fail: %.2f%%%n", under3 * 1.0 / students * 100);
        System.out.printf("Average: %.2f", total / students);
    }
}
