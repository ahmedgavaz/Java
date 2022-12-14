import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OS_Planning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tasks = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] threats = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int value = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> task = new ArrayDeque();
        ArrayDeque<Integer> threat = new ArrayDeque<>();
        for (int i = 0; i < tasks.length; i++) {
            task.push(tasks[i]);
        }
        for (int i = 0; i < threats.length; i++) {
            threat.offer(threats[i]);
        }
        while (true){
            if (task.peek()==value){
                System.out.println("Thread with value "+threat.peek()+" killed task "+task.peek());
                break;
            }
            if (threat.peek()>=task.peek()){
                threat.poll();
                task.pop();
            }
            else{
                threat.poll();
            }
        }
        for (int elem:threat) {
            System.out.print(elem+" ");
        }
    }
}
