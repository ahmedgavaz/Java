import java.text.DecimalFormat;
import java.util.Scanner;

public class Task_other {
    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
     */

    /**
     *
     * @author danie
     */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Illegal arguments found!");
            System.exit(0);
        }
        DecimalFormat df = new DecimalFormat("#.###");
        do {
            String loanInputMessage = "Please enter a valid loan amount: ";
            String loanOutputMessage = "You entered this amount for calculation: ";
            double loanAmount = validatingOfInput(loanInputMessage, loanOutputMessage);

            String annualInterestInputMessage = "Please enter a valid annual interest rate in %: ";
            String annualInterestOutputMessage = "You entered this annual interest rate for calculation: ";
            double annualInterestRate = validatingOfInput(annualInterestInputMessage, annualInterestOutputMessage);

            double monthlyInterestRateInPercent = annualInterestRate / 12;
            System.out.println("So, the monthly interest rate is: " + df.format(monthlyInterestRateInPercent) + " %");

            String monthlyPaymentInputMessage = "Please enter a valid monthly payment: ";
            String monthlyPaymentOutputMessage = "You entered this monthly payment for calculation: ";
            double monthlyPayment = validatingOfInput(monthlyPaymentInputMessage, monthlyPaymentOutputMessage);

            System.out.println("The loan will develop as follows:");
            int month = 1;
            System.out.println("Month    startLoanAmount      InterestRate     Payment     endLoanAmount");
            System.out.println("-------------------------------------------------------------------------");
            while (loanAmount > 0) {
                double interestRate = loanAmount * (monthlyInterestRateInPercent / 100);

                double endLoanAmount = loanAmount - monthlyPayment + interestRate;
                System.out.printf("%3d       %10.2f €          %6.2f €       %6.2f €    %10.2f €%n",
                        month, loanAmount, interestRate, monthlyPayment, endLoanAmount);

                if ((endLoanAmount > loanAmount) && (month == 12)) {
                    System.out.println(" The monthly installment is too low!");
                    break;
                }
                loanAmount = endLoanAmount;
                month = month + 1;
            }

        } while (doItAgain());

        System.out.println("Good bye!");
    }

    private static boolean doItAgain() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Do you want to calculate another loan? ");
        System.out.print("(Y/N): ");
        String answer = scanner.nextLine().toUpperCase().trim();
        return answer.equals("Y");
    }

    public static double validatingOfInput(String inputMessage, String outputMessage) {
        Scanner scanner= new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###");
        do {
            System.out.print(inputMessage);
            try {
                double value = Double.parseDouble(scanner.nextLine());
                if (value > 0) {
                    String endMessage;
                    if (inputMessage.contains("%")){
                        endMessage = " %";
                    }else{
                        endMessage = " Euro";
                    }
                    System.out.println(outputMessage + df.format(value) + endMessage);
                    return value;
                }
            } catch (Exception e) {
                System.out.println("Invalid input...");
            }
        } while (true);
    }
}
