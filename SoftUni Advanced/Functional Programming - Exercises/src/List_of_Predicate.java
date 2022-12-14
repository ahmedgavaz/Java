import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class List_of_Predicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        BiFunction<List<Integer>,Integer, Boolean> isDivisible = (a,b)->{
            for (Integer elem:a) {
                if (b%elem!=0){
                    return false;
                }
            }
            return true;
        };
        for (int i = 1; i <= n; i++) {
            if (isDivisible.apply(list,i)){
                System.out.print(i+" ");
            }
        }
    }
}
