import java.util.Scanner;

public class Number_Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int num = 1;
        for (int i = 1; i <= number ; i++) {
            for (int j = 1; j <= i; j++) {
                if (num>number){
                    return;
                }
                System.out.print(num + " ");
                num++;
            }
            System.out.println("");
        }
    }
}
