import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Reverse_And_Exclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(list);
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> isDivided = e->e%n==0;
        list.removeIf(isDivided);
        list.stream().forEach(e -> System.out.print(e + " "));
    }
}
