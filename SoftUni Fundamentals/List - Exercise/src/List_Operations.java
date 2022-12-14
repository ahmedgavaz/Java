import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class List_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commands = command.split(" ");
            switch (commands[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(commands[1]));
                    break;
                case "Insert":
                    if (numbers.size() <= Integer.parseInt(commands[2]) || 0>Integer.parseInt(commands[2])) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.add(Integer.parseInt(commands[2]), Integer.parseInt(commands[1]));
                    }
                    break;
                case "Remove":
                    if (numbers.size() <= Integer.parseInt(commands[1]) || 0>Integer.parseInt(commands[1])) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.remove(Integer.parseInt(commands[1]));
                    }
                    break;
                case "Shift":
                    switch (commands[1]) {
                        case "left":
                            for (int i = 0; i < Integer.parseInt(commands[2]); i++) {
                                int temp = numbers.get(0);
                                for (int j = 0; j < numbers.size() - 1; j++) {
                                    numbers.set(j, numbers.get(j + 1));
                                }
                                numbers.set(numbers.size() - 1, temp);
                            }
                            break;
                        case "right":
                            for (int i = 0; i < Integer.parseInt(commands[2]); i++) {
                                int temp = numbers.get(numbers.size() - 1);
                                for (int j = numbers.size() - 1; j > 0; j--) {
                                    numbers.set(j, numbers.get(j - 1));
                                }
                                numbers.set(0, temp);
                            }
                            break;
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
