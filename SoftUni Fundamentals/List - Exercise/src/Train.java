import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int capacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("end")){
            String[] commands = command.split(" ");
            if (commands[0].equals("Add")){
                wagons.add(Integer.parseInt(commands[1]));
            }else {
                int adding = Integer.parseInt(commands[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i)+adding<=capacity){
                        wagons.set(i,wagons.get(i)+adding);
                        break;
                    }
                }
            }
            command=scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]",""));
    }
}
