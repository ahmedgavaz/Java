import java.util.Scanner;

public class Number_Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <=n; i++){
            int a = Integer.parseInt(scanner.nextLine());
            if (a > max){
                max = a;
            }if (a < min){
                min = a;
            }
        }
        System.out.println("Max number: " + max);
        System.out.println("Min number: " + min);
    }
}
