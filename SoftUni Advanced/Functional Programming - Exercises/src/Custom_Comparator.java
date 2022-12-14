import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Custom_Comparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        BiFunction<Integer,Integer,Integer> comparing = (a,b)->{
            if (a%2==0 && b%2==0){
                return a-b;
            }else if(a%2==0 && b%2!=0){
                return -1;
            }else if (a%2!=0 && b%2!=0){
                return a-b;
            }
            else{
                return 1;
            }
        };
        list.stream().sorted((a,b)->comparing.apply(a,b)).forEach(e-> System.out.print(e+" "));
    }
}
