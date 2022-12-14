import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Merging_Lists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> first = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> third = new ArrayList<>();
        if (first.size()>=second.size()){
            for (int i = 0; i < second.size(); i++) {
                third.add(first.get(i));
                third.add(second.get(i));
            }
            third.addAll(first.subList(second.size(),first.size()));
        }else{
            for (int i = 0; i < first.size(); i++) {
                third.add(first.get(i));
                third.add(second.get(i));
            }
            third.addAll(second.subList(first.size(), second.size()));
        }
        System.out.println(third.toString().replaceAll("[\\[\\],]",""));
    }
}
