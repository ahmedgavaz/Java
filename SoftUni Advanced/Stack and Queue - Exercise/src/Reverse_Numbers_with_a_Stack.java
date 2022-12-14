import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Reverse_Numbers_with_a_Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String elem:numbers) {
            stack.push(elem);
        }
        for (String elem:stack) {
            System.out.print(elem+" ");
        }
    }
}
