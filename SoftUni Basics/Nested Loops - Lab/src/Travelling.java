import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();
        while (!destination.equals("End")){
            String country = destination;
            double budget = Double.parseDouble(scanner.nextLine());
            double sum =0;
            while (budget>sum){
                double money =Double.parseDouble(scanner.nextLine());
                sum=sum+money;
            }
            System.out.println("Going to "+ country + "!");
            destination = scanner.nextLine();
        }
    }
}
