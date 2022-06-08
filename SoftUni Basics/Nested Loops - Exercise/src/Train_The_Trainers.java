import java.util.Scanner;

public class Train_The_Trainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double totalSum = 0;
        int count = 0;
        String name = scanner.nextLine();
        while (!name.equals("Finish")) {
            String title = name;
            double sum = 0;
            for (int i = 1; i <= n; i++) {
                double assessment = Double.parseDouble(scanner.nextLine());
                sum += assessment;
                totalSum += assessment;
                count++;
            }
            System.out.printf("%s - %.2f.%n", title, sum / n);
            name = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", (totalSum / count));
    }
}
