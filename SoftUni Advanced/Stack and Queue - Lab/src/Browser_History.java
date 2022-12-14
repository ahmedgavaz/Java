import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser_History {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> sites = new ArrayDeque<>();
        while (!command.equals("Home")){
            if (command.equals("back")){
                if (sites.size()<=1){
                    System.out.println("no previous URLs");
                }else{
                    sites.pop();
                    System.out.println(sites.peek());
                }
            }else{
                sites.push(command);
                System.out.println(command);
            }
            command= scanner.nextLine();
        }
    }
}
