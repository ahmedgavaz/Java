import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Append_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\|");
        List<String> list = new ArrayList<>();
        int n=0;
        for (int i = numbers.length-1; i >=0; i--) {
            char[] digits = numbers[i].toCharArray();
            for (int j = 0; j < digits.length; j++) {
                if ((digits[j]>='0' && digits[j]<='9') || digits[j]=='-'){
                    if (j==digits.length-1){
                        list.add(String.valueOf(digits[j])+" ");
                        n=1;
                    }else{
                        list.add(String.valueOf(digits[j]));
                        n=0;
                    }
                    }
                else if (n==0){
                    list.add(String.valueOf(" "));
                    n++;
                }
            }

        }
        for (String number:list) {
            System.out.print(number);;
        }
    }
}
