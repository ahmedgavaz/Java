import java.util.Arrays;
import java.util.Scanner;

public class Array_Modifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command =scanner.nextLine();
        while (!command.equals("end")){
            String[] commands = command.split(" ");
            switch (commands[0]){
                case "swap":
                    int temp = array[Integer.parseInt(commands[1])];
                    array[Integer.parseInt(commands[1])]=array[Integer.parseInt(commands[2])];
                    array[Integer.parseInt(commands[2])]=temp;
                    break;
                case "multiply":
                    array[Integer.parseInt(commands[1])]*=array[Integer.parseInt(commands[2])];
                    break;
                case "decrease":
                    for (int i = 0; i < array.length; i++) {
                        array[i]-=1;
                    }
                    break;
            }
            command =scanner.nextLine();
        }
        for (int i = 0; i < array.length-1; i++) {
            System.out.print(array[i]+", ");
        }
        System.out.println(array[array.length-1]);
    }
}
