import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;

public class Custom_Min_Function {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e-> Integer.valueOf(e)).toArray();
        Function<int[],Integer> minElement = arr-> Arrays.stream(arr).min().getAsInt();
        System.out.println(minElement.apply(numbers));
    }
}
