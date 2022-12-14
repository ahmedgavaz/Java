import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sum_Adjacent_Equal_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> number = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        for (int i = 0; i < number.size()-1; i++) {
            double first = number.get(i);
            double second = number.get(i+1);
            if (first==second){
                number.set(i,2*number.get(i));
                number.remove(number.get(i+1));
                i=-1;
            }
        }
        System.out.println(concatenation(number," "));
    }
    public static String concatenation(List<Double> list ,String splitter){
        String text="";
        for (Double number:list) {
            DecimalFormat df= new DecimalFormat("0.#");
            text+= df.format(number)+splitter;
        }
        return text;
    }
}
