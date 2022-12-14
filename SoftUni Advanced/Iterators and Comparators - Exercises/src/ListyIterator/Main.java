package ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        if (input.length <= 1) {
            System.out.println("Invalid Operation!");
        } else {
            String[] input2 = new String[input.length - 1];
            for (int i = 1; i < input.length; i++) {
                input2[i - 1] = input[i];
            }
            ListyIterator arr = new ListyIterator(input2);
            String command = scanner.nextLine();
            while (!command.equals("END")) {
                switch (command) {
                    case "Print":
                        arr.Print();
                        break;
                    case "HasNext":
                        arr.HasNext();
                        break;
                    case "Move":
                        arr.Move();
                        break;
                    case "PrintAll":
                        Iterator<String> iterator = arr.iterator();
                        while (iterator.hasNext()){
                            System.out.printf("%s ",iterator.next());
                        }
                        System.out.println();
                        break;
                }
                command = scanner.nextLine();
            }
        }
    }
}
