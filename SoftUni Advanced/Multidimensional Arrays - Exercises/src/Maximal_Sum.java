import java.util.Arrays;
import java.util.Scanner;

public class Maximal_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a= scanner.nextInt();
        int b = scanner.nextInt();
        int[][] arr = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j]= scanner.nextInt();
            }
        }
        int n=0;
        int m=0;
        int sum=Integer.MIN_VALUE;
        for (int i = 0; i <= a-3; i++) {
            for (int j = 0; j <= b-3; j++) {
                int suma = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                if (sum<suma){
                    sum=suma;
                    n=i;
                    m=j;
                }
            }
        }
        System.out.println("Sum = "+sum);
        for (int i = n; i <n+3 ; i++) {
            for (int j = m; j < m+3; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
}
