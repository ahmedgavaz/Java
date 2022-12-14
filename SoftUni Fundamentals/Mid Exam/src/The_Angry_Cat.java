import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class The_Angry_Cat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listItems= Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        int index=Integer.parseInt(scanner.nextLine());
        String value = scanner.nextLine();
        int sum1=0;
        int sum2=0;
        switch (value){
            case "cheap":
                for (int i = 0; i < index; i++) {
                    if (listItems.get(i)<listItems.get(index)){
                    sum1+=listItems.get(i);}
                }
                for (int i = index+1; i <listItems.size() ; i++) {
                    if (listItems.get(i)<listItems.get(index)){
                        sum2+=listItems.get(i);}
                }
                if (sum1>=sum2){
                    System.out.printf("Left - %d",sum1);
                }else{
                    System.out.printf("Right - %d",sum2);
                }
                break;
            case "expensive":
                for (int i = 0; i < index; i++) {
                    if (listItems.get(i)>=listItems.get(index)){
                        sum1+=listItems.get(i);}
                }
                for (int i = index+1; i <listItems.size() ; i++) {
                    if (listItems.get(i)>=listItems.get(index)){
                        sum2+=listItems.get(i);}
                }
                if (sum1>=sum2){
                    System.out.printf("Left - %d",sum1);
                }else{
                    System.out.printf("Right - %d",sum2);
                }
                break;
        }
    }
}
