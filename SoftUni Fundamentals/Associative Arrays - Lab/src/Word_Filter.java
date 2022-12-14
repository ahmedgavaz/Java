import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Word_Filter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] listWords = Arrays.stream(scanner.nextLine().split(" ")).filter(e -> e.length() % 2 == 0).toArray(String[]::new);
        System.out.println(String.join(System.lineSeparator(),listWords));
    }
}
