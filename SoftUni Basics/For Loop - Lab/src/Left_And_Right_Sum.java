import java.util.Scanner;

public class Left_And_Right_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum1 = 0;
        int sum2 =0;
        for (int i = 1;i <=n;i++){
            int a = Integer.parseInt(scanner.nextLine());
            sum1 += a;
        }
        for (int i = 1;i <=n;i++){
            int a = Integer.parseInt(scanner.nextLine());
            sum2 += a;
        }
        if (sum1 == sum2){
            System.out.printf("Yes, sum = %d",sum1);
        }else System.out.printf("No, diff = %d",Math.abs(sum1-sum2));
    }
}
