import java.util.Scanner;

public class New_House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        if (type.equals("Roses")){
            sum = sum + number * 5;
            if (number > 80){
                sum = sum * 0.9;
            }
        }
        if (type.equals("Dahlias")){
            sum = sum + number * 3.8;
            if (number > 90){
                sum = sum * 0.85;
            }
        }
        if (type.equals("Tulips")){
            sum = sum + number * 2.8;
            if (number > 80){
                sum = sum * 0.85;
            }
        }
        if (type.equals("Narcissus")){
            sum = sum + number * 3;
            if (number < 120){
                sum = sum * 1.15;
            }
        }
        if (type.equals("Gladiolus")){
            sum = sum + number * 2.5;
            if (number < 80){
                sum = sum * 1.2;
            }
        }
        if (budget >= sum){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",number,type,budget-sum);
        }else System.out.printf("Not enough money, you need %.2f leva more.",sum-budget);
    }
}
