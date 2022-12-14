import java.util.Arrays;
import java.util.Scanner;

public class Max_Sequence_of_Equal_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index=0;
        int sum=0;
        for (int i=0;i<array.length;i++) {
            int suma=0;
            for (int j = i; j < array.length; j++) {
                if (array[i]==array[j] && i!=j){
                    suma++;
                }
                if (array[i]!=array[j]){
                    break;
                }
            }
            if (sum<suma){
                index=i;
                sum=suma;
            }
        }
        for (int i = 0; i <=sum ; i++) {
            System.out.print(array[index]+" ");
        }
    }
}
