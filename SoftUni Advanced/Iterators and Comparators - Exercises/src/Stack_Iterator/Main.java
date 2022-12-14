package Stack_Iterator;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[, |\\s]");
        if (input.length <= 1) {
            System.out.println("No elements");
        } else {
            Stack arr = new Stack();
            ArrayDeque<Integer> array = new ArrayDeque<>();
            for (int i = 1; i < input.length; i = i + 2) {
                arr.push(Integer.parseInt(input[i]));
            }
            String command = scanner.nextLine();
            while (!command.equals("END")) {
                String[] commands = command.split("[, |\\s]");
                switch (commands[0]) {
                    case "Pop":
                        if (arr.size()==0){
                            System.out.printf("No elements");
                            return;
                        }
                        arr.pop();
                        break;
                    case "Push":
                        Integer[] b= new Integer[commands.length-1];
                        for (int i = 1; i <commands.length; i = i + 2) {
                            b[i-1]=Integer.parseInt(commands[i]);
                        }
                        for (int i = 0; i < b.length; i=i+2) {
                            arr.push(b[i]);
                        }
                        break;
                }
                command = scanner.nextLine();
            }
            if (arr.size()==0){
                System.out.printf("No elements");
                return;
            }
            Iterator<Integer> iterator = arr.iterator();
            while (iterator.hasNext()) {
                int a = iterator.next();
                array.offer(a);
                System.out.printf("%d%n", a);
            }
            while (array.size()>0){
                System.out.println(array.poll());
            }
        }
    }
}
