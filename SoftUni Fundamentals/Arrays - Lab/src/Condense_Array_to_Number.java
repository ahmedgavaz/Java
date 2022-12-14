import java.util.Arrays;
import java.util.Scanner;

public class Condense_Array_to_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        /*for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1; j++) {
                array[j]+=array[j+1];
            }
        }
        System.out.println(array[0]);*/
        int len = array.length;
        for (int i = 0; i < len-1; i++) {
            int[] cons=new int[array.length-1];
            for (int j = 0; j < cons.length; j++) {
                cons[j]=array[j]+array[j+1];
            }
            array=cons;
        }
        System.out.println(array[0]);
    }
}
