import java.util.Scanner;

public class Half_Sum_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 1; i <= n; i++){
            int a = Integer.parseInt(scanner.nextLine());
            sum += a;
            if (a > max){
                max = a;
            }
        }
        int sum1 = sum - max;
        if (sum1 == max){
            System.out.println("Yes");
            System.out.println("Sum = "+ max);
        }else{
            System.out.println("No");
            System.out.println("Diff = " + Math.abs(max - sum1));
        }
    }
}
