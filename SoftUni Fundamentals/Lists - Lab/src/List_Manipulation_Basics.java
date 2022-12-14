import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class List_Manipulation_Basics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("end")){
            String[] words = command.split(" ");
            switch (words[0]){
                case "Add":
                    numbers.add(Integer.parseInt(words[1]));
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(Integer.parseInt(words[1])));
                    break;
                case "RemoveAt":
                    numbers.remove(Integer.parseInt(words[1]));
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(words[2]),Integer.parseInt(words[1]));
                    break;
            }
            command= scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
