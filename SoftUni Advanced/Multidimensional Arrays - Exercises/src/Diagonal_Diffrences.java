import java.util.Arrays;
import java.util.Scanner;

public class Diagonal_Diffrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [][] arr=new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i]= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int sumDiag = 0;
        int sumSecond = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j){
                    sumDiag+=arr[i][j];
                }
                if(arr.length-1==i+j){
                    sumSecond+=arr[i][j];
                }
            }
        }
        System.out.println(Math.abs(sumDiag-sumSecond));
    }
}
