import java.util.Scanner;

public class Factorial_Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1=Integer.parseInt(scanner.nextLine());
        int n2=Integer.parseInt(scanner.nextLine());
        double result=factorial(n1,n2);
        System.out.printf("%.2f",result);
    }
    public static double factorial(double n1,double n2){
        double sum1=1;
        double sum2=1;
        for (int i = 1; i <=n1 ; i++) {
            sum1*=i;
        }
        for (int i = 1; i <=n2 ; i++) {
            sum2*=i;
        }
        return sum1/sum2;
    }
}
