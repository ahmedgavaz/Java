import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class Cards_Games {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> first = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        while (first.size()>0 && second.size()>0){
            if (first.get(0)>second.get(0)){
                first.add(first.get(0));
                first.add(second.get(0));
            }else if (first.get(0)<second.get(0)){
                second.add(second.get(0));
                second.add(first.get(0));
            }
            first.remove(0);
            second.remove(0);
        }
        int sum=0;
        if (first.size()==0){
            for (int card:second) {
                sum+=card;
            }
            System.out.println("Second player wins! Sum: "+sum);
        }else{
            for (int card:first) {
                sum+=card;
            }
            System.out.println("First player wins! Sum: "+sum);
        }
    }
}
