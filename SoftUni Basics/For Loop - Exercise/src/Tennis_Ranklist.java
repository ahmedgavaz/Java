import java.util.Scanner;

public class Tennis_Ranklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int points = Integer.parseInt(scanner.nextLine());
        int wins = 0;
        int tourPoints = 0;
        for (int i = 1; i <= n; i++){
            String s = scanner.nextLine();
            switch (s){
                case "W":
                    tourPoints += 2000;
                    wins ++;
                    break;
                case "F":
                    tourPoints += 1200;
                    break;
                case "SF":
                    tourPoints += 720;
                    break;
            }
        }
        System.out.println("Final points: "+ (points + tourPoints));
        System.out.println("Average points: " + (tourPoints / n));
        System.out.printf("%.2f%%",wins * 1.0 / n *100);
    }
}
