import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double neededMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());
        int br = 0;
        int br1 = 0;
        while (availableMoney < neededMoney) {
            if (br==5){
                break;
            }
            String action = scanner.nextLine();
            br1++;
            if (action.equals("spend")) {
                br=br+1;
                double money = Double.parseDouble(scanner.nextLine());
                availableMoney -= money;
                if (availableMoney < 0) {
                    availableMoney = 0;
                }
            } else if (action.equals("save")) {
                br=0;
                double money = Double.parseDouble(scanner.nextLine());
                availableMoney += money;
                if (availableMoney >= neededMoney) {
                    System.out.println("You saved the money for " + br1 + " days.");
                    return;
                }
            }
        }
        if (br == 5){
            System.out.println("You can't save the money.");
            System.out.println(br1);
        }
    }
}
