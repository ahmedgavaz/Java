import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Hot_Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue,kids);
        int n = Integer.parseInt(scanner.nextLine());
        int br =0;
        while (queue.size()>1){
            br++;
            String name = queue.poll();
            if (n==br){
                System.out.println("Removed "+name);
                br=0;
            }else{
                queue.offer(name);
            }
        }
        System.out.println("Last is "+queue.poll());
    }
}
