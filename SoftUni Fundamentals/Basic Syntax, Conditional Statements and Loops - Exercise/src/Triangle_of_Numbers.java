import java.util.Scanner;
public class Triangle_of_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number =Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=number ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i+" ");
            }
            System.out.printf("%n");
        }
    }
}
