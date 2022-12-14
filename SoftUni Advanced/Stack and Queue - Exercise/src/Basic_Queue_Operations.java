import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Basic_Queue_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            stack.offer(scanner.nextInt());
        }
        for (int i = 0; i < s; i++) {
            stack.poll();
        }
        boolean bol = false;
        for (int elem : stack) {
            if (elem == x) {
                bol = true;
                break;
            }
        }
        if (bol) {
            System.out.println("true");
        } else {
            if (stack.size() == 0) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
