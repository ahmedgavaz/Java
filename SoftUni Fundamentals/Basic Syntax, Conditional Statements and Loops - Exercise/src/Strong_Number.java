import java.util.Scanner;
public class Strong_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int num=number;
        int sum=0;
        while (number>10){
            int lastNum=number%10;
            int p=1;
            for (int i = 1; i <= lastNum; i++) {
                p=p*i;
            }
            sum=sum+p;
            number=number/10;
        }
        int p=1;;
        for (int i = 1; i <= number; i++) {
            p=p*i;
        }
        sum+=p;
        if(num==sum){
            System.out.println("yes");
        }
        else System.out.println("no");
    }
}
