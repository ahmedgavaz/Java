import java.util.Scanner;

public class Sum_Prime_Non_Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstNumber = scanner.nextLine();
        int sumPrime=0;
        int sumNonPrime=0;
        while (!firstNumber.equals("stop")){
            int number = Integer.parseInt(firstNumber);
            if (number<0){
                System.out.println("Number is negative.");
            }
            else{
                boolean bol =true;
                for (int i = 2; i < number; i++) {
                  if (number % i ==0){
                      bol=false;
                  }
                }
                if (bol == false){
                    sumNonPrime+=number;
                }else sumPrime+=number;
            }
            firstNumber = scanner.nextLine();
        }
        System.out.println("Sum of all prime numbers is: "+sumPrime);
        System.out.println("Sum of all non prime numbers is: "+sumNonPrime);
    }
}
