import java.util.Scanner;

public class Zig_Zag_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int[] array1 = new int[lines];
        int[] array2 = new int[lines];
        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            int number1 = Integer.parseInt(line.split(" ")[0]);
            int number2 = Integer.parseInt(line.split(" ")[1]);
            if (i%2==0){
                array1[i]=number1;
                array2[i]=number2;
            }
            else{
                array1[i]=number2;
                array2[i]=number1;
            }
        }
        for (int num:array1) {
            System.out.print(num+" ");
        }
        System.out.println();for (int num:array2){
            System.out.print(num+ " ");
        }
    }
}
