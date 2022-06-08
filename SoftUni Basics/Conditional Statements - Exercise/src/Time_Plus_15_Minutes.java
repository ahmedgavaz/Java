import java.util.Scanner;

public class Time_Plus_15_Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int sum = hour * 60 + minutes + 15;
        int hour1 = sum / 60;
        int minutes1 = sum % 60;
        if (sum / 60 <24) {
            System.out.printf("%d:%02d",hour1,minutes1);
        }
        else System.out.printf("0:%02d",minutes1);
    }
}

