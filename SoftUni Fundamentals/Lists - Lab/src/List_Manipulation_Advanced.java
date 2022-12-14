import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class List_Manipulation_Advanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] words = command.split(" ");
            switch (words[0]) {
                case "Contains":
                    boolean bol = false;
                    for (int num : numbers) {
                        if (num == Integer.parseInt(words[1])) {
                            bol = true;
                            break;
                        }
                    }
                    if (bol == true) {
                        System.out.println("Yes");
                    } else System.out.println("No such number");
                    break;
                case "Print":
                    switch (words[1]) {
                        case "even":
                            for (int num : numbers) {
                                if (num % 2 == 0) {
                                    System.out.print(num + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "odd":
                            for (int num : numbers) {
                                if (num % 2 == 1) {
                                    System.out.print(num + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int num : numbers) {
                        sum += num;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    switch (words[1]) {
                        case ">":
                            for (int num : numbers) {
                                if (num > Integer.parseInt(words[2])) {
                                    System.out.print(num + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<":
                            for (int num : numbers) {
                                if (num < Integer.parseInt(words[2])) {
                                    System.out.print(num + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (int num : numbers) {
                                if (num >= Integer.parseInt(words[2])) {
                                    System.out.print(num + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (int num : numbers) {
                                if (num <= Integer.parseInt(words[2])) {
                                    System.out.print(num + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
