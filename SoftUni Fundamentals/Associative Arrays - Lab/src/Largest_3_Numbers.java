import java.util.Arrays;
import java.util.Scanner;

public class Largest_3_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).sorted((e1,e2) -> e2.compareTo(e1)).limit(3).toArray(Integer[]::new);
        for (Integer elem :numbers) {
            System.out.print(elem+" ");
        }
    }
}
