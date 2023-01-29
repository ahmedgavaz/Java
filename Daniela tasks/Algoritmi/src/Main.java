import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
        printArray(arr);
    }
    public static void printArray(int[] arr) {
        int[] arr1 = Arrays.copyOfRange(arr, 1, arr.length);
        if (arr1.length==1) {
            System.out.print(arr1[0]);
            //  return;
        }else {
            printArray(arr1);
        }
        System.out.print(arr[0]);

    }
}
