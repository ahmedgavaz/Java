import java.util.Scanner;

public class Trekking_Mania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++){
            int a = Integer.parseInt(scanner.nextLine());
            sum += a;
            if (a <= 5){
                p1 += a;
            }else if (a <= 12){
                p2 += a;
            }else if (a <= 25){
                p3 += a;
            }else if (a <= 40){
                p4 += a;
            }else if (a > 40){
                p5 += a;
            }
        }
        System.out.printf("%.2f%%%n",p1 * 1.0 / sum *100);
        System.out.printf("%.2f%%%n",p2 * 1.0 / sum *100);
        System.out.printf("%.2f%%%n",p3 * 1.0 / sum *100);
        System.out.printf("%.2f%%%n",p4 * 1.0 / sum *100);
        System.out.printf("%.2f%%%n",p5 * 1.0 / sum *100);
    }
}
