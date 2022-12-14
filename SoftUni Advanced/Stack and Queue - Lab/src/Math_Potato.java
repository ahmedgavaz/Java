import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Math_Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, kids);
        int n = Integer.parseInt(scanner.nextLine());
        int br = 0;
        int cycle = 0;
        while (queue.size() > 1) {
            br++;
            String name = queue.poll();
            if (n == br) {
                cycle++;
                if (!isPrime(cycle)) {
                    System.out.println("Removed " + name);
                } else {
                    System.out.println("Prime " + name);
                    queue.push(name);
                }
                br=0;
            } else {
                queue.offer(name);
            }
        }
        System.out.println("Last is " + queue.poll());
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}