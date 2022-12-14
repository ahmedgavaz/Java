import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Fix_Emails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("stop")){
            String mail = scanner.nextLine();
            if (!mail.endsWith("us") && !mail.endsWith("uk") && !mail.endsWith("com")){
                emails.put(command,mail);
            }
            command= scanner.nextLine();
        }
        emails.forEach((key, value) -> System.out.println(key +" -> "+value));
    }
}
