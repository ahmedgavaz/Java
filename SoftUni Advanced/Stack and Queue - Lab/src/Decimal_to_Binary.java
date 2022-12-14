import java.util.ArrayDeque;
import java.util.Scanner;

public class Decimal_to_Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();
        if (number==0){
            System.out.println(0);
        }else{
            while(number>0){
                binary.push(number%2);
                number/=2;
            }
        }
        for (int num:binary) {
            System.out.print(num);
        }
    }
}
