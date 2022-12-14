import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Simple_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr=scanner.nextLine().split(" ");
        ArrayDeque<String> numbers = new ArrayDeque<>();
        Collections.addAll(numbers,arr);
        while (numbers.size()>1){
            int number1=Integer.parseInt(numbers.pop());
            String sign = numbers.pop();
            int number2=Integer.parseInt(numbers.pop());
            int res =0;
            if (sign.equals("+")){
                res = number1+number2;
            }else{
                res = number1-number2;
            }
            numbers.push(String.valueOf(res));
        }
        System.out.println(numbers.peek());
    }
}
