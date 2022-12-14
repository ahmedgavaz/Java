import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Find_The_Smallest_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>,Integer> minimal = e-> Collections.min(e);
        System.out.println(list.lastIndexOf(minimal.apply(list)));
    }
}
