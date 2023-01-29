import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean startAgain = true;
        while (startAgain = true) {
            System.out.print("Please enter a valid load amount: ");
            double startLoanAmount = Double.parseDouble(scanner.nextLine());
            if (startLoanAmount <= 0) {
                while (startLoanAmount <= 0) {
                    System.out.print("Please enter a valid load amount: ");
                    startLoanAmount = Double.parseDouble(scanner.nextLine());
                }
            }
            System.out.print("Please enter a valid annual interest rate in %: ");
            double annualInterestRate = Double.parseDouble(scanner.nextLine());
            if (annualInterestRate <= 0) {
                while (annualInterestRate <= 0) {
                    System.out.print("Please enter a valid annual interest rate in %: ");
                    annualInterestRate = Double.parseDouble(scanner.nextLine());
                }
            }
            double monthlyInterestRate = annualInterestRate / 12;
            System.out.print("Please enter a valid monthly payment: ");
            double monthlyPayment = Double.parseDouble(scanner.nextLine());
            if (monthlyPayment <= 0) {
                while (monthlyPayment <= 0) {
                    System.out.print("Please enter a valid monthly payment: ");
                    monthlyPayment = Double.parseDouble(scanner.nextLine());
                }
            }
            int month = 1;
            System.out.println("Month   startLoanAmount     InterestRate    Payment     endLoanAmount");
            System.out.println("---------------------------------------------------------------------");
            while (startLoanAmount > 0) {
                double interestRate = startLoanAmount * (monthlyInterestRate / 100);
                if (monthlyPayment<=interestRate){
                    System.out.println("Illegal arguments found!");
                    break;
                }
                double endLoanAmount = startLoanAmount - monthlyPayment + interestRate;
                System.out.printf("%2d       %9.2f €          %5.2f €       %5.2f €        %7.2f €%n", month, startLoanAmount, interestRate, monthlyPayment, endLoanAmount);
                startLoanAmount = endLoanAmount;
                month = month + 1;
            }
            System.out.println("Do you want to calculate another loan?");
            String answer = scanner.nextLine();
            if (answer.equals("N")){
                break;
            }
        }
        System.out.println("Good bye!");
    }
}//33333 2 34
