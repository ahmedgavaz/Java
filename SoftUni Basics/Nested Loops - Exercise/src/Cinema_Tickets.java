import java.util.Scanner;

public class Cinema_Tickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int totalStudent = 0;
        int totalStandard = 0;
        int totalKids = 0;
        int total = 0;
        while (!name.equals("Finish")) {
            String movie = name;
            int freePlaces = Integer.parseInt(scanner.nextLine());
            int places = 0;
            String type = scanner.nextLine();
            while (!type.equals("End")) {
                String ticket = type;
                places++;
                total++;
                if (ticket.equals("standard")) {
                    totalStandard++;
                } else if (ticket.equals("kid")) {
                    totalKids++;
                } else if (ticket.equals("student")) {
                    totalStudent++;
                }
                if (freePlaces==places){
                    break;
                }
                type = scanner.nextLine();
            }
            System.out.printf("%s - %.2f%% full.%n", movie, places * 1.0 / freePlaces * 100);
            name = scanner.nextLine();
        }
        System.out.println("Total tickets: " + total);
        System.out.printf("%.2f%% student tickets.%n", totalStudent * 1.0 / total*100);
        System.out.printf("%.2f%% standard tickets.%n", totalStandard * 1.0 / total*100);
        System.out.printf("%.2f%% kids tickets.%n", totalKids * 1.0 / total*100);
    }
}
