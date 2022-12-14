import java.util.Scanner;

public class Print_Numbers_in_Reverse_Order {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers =Integer.parseInt(scanner.nextLine());
        int[] array = new int[numbers];
        for (int i = 0; i <array.length ; i++) {
            array[i]=Integer.parseInt(scanner.nextLine());
        }
        for (int i = array.length-1; i >=0 ; i--) {
            System.out.print(array[i]+" ");
        }
    }
}
