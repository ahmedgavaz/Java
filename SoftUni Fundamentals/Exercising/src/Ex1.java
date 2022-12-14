import com.sun.jdi.IntegerValue;

import java.util.*;
import java.util.stream.Collectors;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /* List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(e->Integer.parseInt(e)).collect(Collectors.toList());
        int a = numbers.stream().mapToInt(Integer::intValue).min().getAsInt();
        System.out.println(a);*/
        /*Integer[] numbers = new Integer[5];
        for (int i = 1; i < 6; i++) {
            numbers[i-1]=i*10;
        }
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]",""));
        numbers = Arrays.stream(numbers).map(e->e+5).toArray(Integer[]::new);
        for (int i = 1; i < 6; i++) {
            System.out.println(numbers[i-1]);
        }*/
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            numbers.add(i-1,i*10);
        }
        numbers = numbers.stream().map(e->e+5).collect(Collectors.toList());
        for (int i = 1; i < 6; i++) {
            System.out.println(numbers.get(i-1));;
        }
    }
}
