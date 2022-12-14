import com.sun.jdi.Value;

import java.io.FilterOutputStream;
import java.util.*;

public class Count_Real_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers= Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double,Integer> numbersList= new TreeMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbersList.containsKey(numbers[i])){
                numbersList.put(numbers[i],numbersList.get(numbers[i])+1);
            }
            else{
                numbersList.put(numbers[i],1);
            }
        }
        for (Map.Entry<Double,Integer> elem:numbersList.entrySet()){
            System.out.printf("%.0f -> %d%n",elem.getKey(),elem.getValue());
        }
    }
}
