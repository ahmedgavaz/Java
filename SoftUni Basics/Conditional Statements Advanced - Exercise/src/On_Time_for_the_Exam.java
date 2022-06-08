import java.util.Scanner;

public class On_Time_for_the_Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int hourOfArrival = Integer.parseInt(scanner.nextLine());
        int minOfArrival = Integer.parseInt(scanner.nextLine());

        int examTime = (examHour * 60) + examMinutes;
        int arrivalTime = (hourOfArrival * 60) + minOfArrival;

        int diff = Math.abs(examTime - arrivalTime);

        //exam -> 9:30 = (9 * 60) + 30 = 570
        //arr -> 9:50 = (9 * 60) + 50 = 590
        if (examTime < arrivalTime) {
            System.out.println("Late");

            if (diff >= 60) {
                int hour = diff / 60;
                int min = diff % 60;
                System.out.printf("%d:%02d hours after the start", hour, min);
            } else {
                System.out.printf("%d minutes after the start", diff);
            }

        } else if ((examTime == arrivalTime) || (diff <= 30)) {
            System.out.println("On time");
            if (diff >= 1 && diff <= 30) {
                System.out.printf("%d minutes before the start", diff);
            }

        } else {
            System.out.println("Early");
            if (diff >= 60) {
                int hour = diff / 60;
                int min = diff % 60;
                System.out.printf("%d:%02d hours before the start", hour, min);
            } else {
                System.out.printf("%d minutes before the start", diff);
            }
        }
    }
}
