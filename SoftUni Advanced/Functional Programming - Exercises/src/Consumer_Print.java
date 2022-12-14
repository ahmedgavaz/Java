import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Consumer_Print {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> printing = x-> System.out.println(x);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(x->printing.accept(x));
    }
}
