import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Recursive_Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> first = new ArrayDeque<>();
        ArrayDeque<Long> second = new ArrayDeque<>();
        first.push(0L);
        second.push(1L);
        if (number < 1) {
            System.out.println(1);
        } else {
            for (int i = 1; i <= number; i++) {
                Long a = first.pop();
                Long b = second.pop();
                if (i % 2 == 0) {
                    first.push(a);
                    second.push(a + b);
                } else {
                    first.push(a + b);
                    second.push(b);
                }
            }
            if (number % 2 == 0) {
                System.out.println(second.pop());
            } else {
                System.out.println(first.pop());
            }
        }
    }
}