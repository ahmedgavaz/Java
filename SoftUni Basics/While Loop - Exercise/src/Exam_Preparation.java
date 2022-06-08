import java.util.Scanner;

public class Exam_Preparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int grades = Integer.parseInt(scanner.nextLine());
        int br = 0;
        int br1 = 0;
        double sum = 0;
        String last = "";
        while (br < grades) {
            String exercise = scanner.nextLine();
            if (exercise.equals("Enough")) {
                break;
            }
            int grade = Integer.parseInt(scanner.nextLine());
            if (grade <= 4) {
                br++;
            }
            sum = sum + grade;
            br1 = br1 + 1;
            last = exercise;
        }
        if (br == grades) {
            System.out.println("You need a break, " + grades + " poor grades.");
        } else {
            System.out.printf("Average score: %.2f%n",(sum / br1));
            System.out.println("Number of problems: " + br1);
            System.out.println("Last problem: " + last);
        }
    }
}
