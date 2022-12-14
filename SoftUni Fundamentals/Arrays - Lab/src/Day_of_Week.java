import java.util.Scanner;

public class Day_of_Week {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] day = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int number = Integer.parseInt(scanner.nextLine());
        if (number>0 && number<8){
            System.out.println(day[number-1]);
        }else {
            System.out.println("Invalid day!");
        }
    }
}
