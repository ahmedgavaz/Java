import java.util.Scanner;

public class Fill_The_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(", ");
        int[][] matrix = new int[Integer.parseInt(arr[0])][Integer.parseInt(arr[0])];
        if (arr[1].equals("A")) {
            fillA(matrix, scanner);
        } else {
            fillB(matrix,scanner);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void fillA(int[][] arr, Scanner sc) {
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j][i] = num;
                num++;
            }
        }
    }

    private static void fillB(int[][] arr, Scanner sc) {
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr.length; j++) {
                    arr[j][i] = num;
                    num++;
                }
            } else {
                for (int j = arr.length-1; j >= 0;j--){
                    arr[j][i] = num;
                    num++;
                }
            }
        }
    }
}
