import java.util.Scanner;

public class Reverse_Matrix_Diagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int len = m + n - 2;
        for (int i = n +m - 1; i > 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = m - 1; k >= 0; k--) {
                    if (j + k == len) {
                        System.out.print(arr[j][k] + " ");
                    }
                }
            }
            System.out.println();
            len--;
        }


       /* for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }*/
    }
}

