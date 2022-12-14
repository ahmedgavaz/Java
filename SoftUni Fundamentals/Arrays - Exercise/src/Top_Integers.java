import java.util.Arrays;
import java.util.Scanner;

public class Top_Integers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < array.length; i++) {
            boolean bol=true;
            for (int j = i+1; j < array.length; j++) {
                if (array[i]<=array[j]){
                    bol=false;
                    break;
                }
            }
            if (bol){
                System.out.print(array[i]+" ");
            }
        }
    }
}
