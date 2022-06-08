import java.util.Scanner;

public class Vacation_Books_List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pages = Integer.parseInt(scanner.nextLine());
        int forHour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int pagesForDay = pages / days;
        int hoursPerDay = pagesForDay / forHour;
        System.out.println(hoursPerDay);
    }
}
