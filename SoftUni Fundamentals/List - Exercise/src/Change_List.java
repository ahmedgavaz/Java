import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Change_List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("end")){
            String[] commands = command.split(" ");
            switch (commands[0]){
                case "Delete":
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i)==Integer.parseInt(commands[1])){
                            numbers.remove(Integer.valueOf(Integer.parseInt(commands[1])));
                            i-=1;
                        }
                    }
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(commands[2]),Integer.parseInt(commands[1]));
                    break;
            }
            command= scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
