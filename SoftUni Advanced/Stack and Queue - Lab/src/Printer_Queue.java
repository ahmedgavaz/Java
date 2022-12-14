import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Printer_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();
        while (!command.equals("print")){
            if (command.equals("cancel")){
                if (queue.size()==0){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println("Canceled "+queue.poll());
                }
            }
            else{
                queue.offer(command);
            }
            command= scanner.nextLine();
        }
        for (String elem:queue) {
            System.out.println(elem);
        }
    }
}
