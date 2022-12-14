import java.util.Scanner;

public class Tax_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cars =scanner.nextLine().split(">>");
        double totalTax=0;
        for (int i = 0; i < cars.length; i++) {
            String[] car = cars[i].split(" ");
            switch (car[0]){
                case "family":
                    double tax = 50;
                    tax-=Integer.parseInt(car[1])*5;
                    tax+=(Integer.parseInt(car[2])/3000)*12;
                    System.out.printf("A %s car will pay %.2f euros in taxes.%n",car[0],tax);
                    totalTax+=tax;
                    break;
                case "heavyDuty":
                    tax = 80;
                    tax-=Integer.parseInt(car[1])*8;
                    tax+=(Integer.parseInt(car[2])/9000)*14;
                    System.out.printf("A %s car will pay %.2f euros in taxes.%n",car[0],tax);
                    totalTax+=tax;
                    break;
                case "sports":
                    tax = 100;
                    tax-=Integer.parseInt(car[1])*9;
                    tax+=(Integer.parseInt(car[2])/2000)*18;
                    System.out.printf("A %s car will pay %.2f euros in taxes.%n",car[0],tax);
                    totalTax+=tax;
                    break;
                default:
                    System.out.println("Invalid car type.");
                    break;
            }
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.",totalTax);
    }
}
