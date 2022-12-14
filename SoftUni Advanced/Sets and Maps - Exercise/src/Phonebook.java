import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("search")){
            String[] people = command.split("-");
            phonebook.put(people[0],people[1]);
            command = scanner.nextLine();
        }
        command= scanner.nextLine();
        while (!command.equals("stop")){
            if (phonebook.containsKey(command)){
                System.out.println(command+" -> "+phonebook.get(command));
            }else{
                System.out.println("Contact "+command+" does not exist.");
            }
            command= scanner.nextLine();
        }
    }
}
