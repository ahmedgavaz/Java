import java.util.Arrays;
import java.util.Scanner;

public class Equal_Sums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean bol=true;
        for (int i = 0; i < array.length; i++) {
            int sum1=0;
            int sum2=0;
            for (int j = 0; j < i; j++) {
                sum1+=array[j];
            }
            for (int j = i+1; j < array.length; j++) {
                sum2+=array[j];
            }
            if (sum1==sum2){
                System.out.println(i);
                bol=false;
            }
        }
        if (bol){
            System.out.println("no");
        }
    }
}
