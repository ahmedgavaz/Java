import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String power = scanner.nextLine();
        String[] deleting = power.split(" ");
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == Integer.parseInt(deleting[0])) {
                numbers.remove(i);
                if (i-Integer.parseInt(deleting[1])<0){
                    for (int j = 0; j < i+Integer.parseInt(deleting[1]); j++) {
                        numbers.remove(0);
                    }
                }
                else if (i+Integer.parseInt(deleting[1])>numbers.size()){
                    int index=i-Integer.parseInt(deleting[1]);
                    for (int j = index; j<numbers.size(); j++) {
                        numbers.remove(index);
                    }
                }else{
                        int index=i-Integer.parseInt(deleting[1]);
                        for (int j = index; j<i+Integer.parseInt(deleting[1]); j++) {
                            numbers.remove(index);
                        }
                }
                i = 0;
            }
        }
        int sum = 0;
        for (int elem : numbers) {
            sum += elem;
        }
        System.out.println(sum);
    }
}
