import java.util.Arrays;
import java.util.Scanner;

public class Magic_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum= Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i]+array[j]==sum && i!=j){
                    System.out.println(array[i]+ " "+ array[j]);
                }
            }
        }
    }
}
