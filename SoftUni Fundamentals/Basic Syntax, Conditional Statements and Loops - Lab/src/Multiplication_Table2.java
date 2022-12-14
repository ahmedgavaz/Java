import java.util.Scanner;

public class Multiplication_Table2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int num = Integer.parseInt(scanner.nextLine());
        if (num<=10){
        for (int i = num; i <= 10; i++) {
            System.out.printf("%d X %d = %d%n", number, i, number * i);
        }}
        else{
            System.out.printf("%d X %d = %d%n", number, num, number * num);
        }
    }
}
