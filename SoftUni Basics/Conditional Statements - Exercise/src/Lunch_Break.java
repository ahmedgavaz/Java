import java.util.Scanner;

public class Lunch_Break {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int lengthEpisode = Integer.parseInt(scanner.nextLine());
        int lengthBreak = Integer.parseInt(scanner.nextLine());
        double lunch = lengthBreak * 0.125;
        double relax = lengthBreak * 0.25;
        double sum = lengthBreak -lunch - relax ;
        double leftTime = Math.abs(sum - lengthEpisode);
        if (sum >= lengthEpisode){
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.",name,Math.ceil(leftTime));
        }
        else System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",name,Math.ceil(leftTime));

    }
}
