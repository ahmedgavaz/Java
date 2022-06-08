import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum =0;
        while (sum<10000){
            String text = scanner.nextLine();
            if (text.equals("Going home")){
                int steps = Integer.parseInt(scanner.nextLine());
                sum +=steps;
                break;
            }else {
                int steps = Integer.parseInt(text);
                sum +=steps;
            }
        }
        if (sum >= 10000){
            System.out.println("Goal reached! Good job!");
            System.out.println((sum-10000) + " steps over the goal!");
        }else System.out.println((10000-sum) + " more steps to reach goal.");
    }
}
