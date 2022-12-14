import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Applied_Arithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Consumer<int[]> add= x->{
            for (int i = 0; i < x.length; i++) {
                x[i]=x[i]+1;
            }
        };
        Consumer<int[]> subtract= x->{
            for (int i = 0; i < x.length; i++) {
                x[i]=x[i]-1;
            }
        };
        Consumer<int[]> multiply= x->{
            for (int i = 0; i < x.length; i++) {
                x[i]=x[i]*2;
            }
        };
        Consumer<int[]> print= x->{
            for (int i = 0; i < x.length; i++) {
                System.out.print(x[i]+" ");
            }
            System.out.println();
        };
        String command= scanner.nextLine();
        while (!command.equals("end")){
            switch (command){
                case"add":
                    add.accept(numbers);
                    break;
                case "subtract":
                    subtract.accept(numbers);
                    break;
                case "multiply":
                    multiply.accept(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    break;
            }
            command= scanner.nextLine();
        }
    }
}
