import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser_History_Upgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> sites = new ArrayDeque<>();
        ArrayDeque<String> next = new ArrayDeque<>();
        while (!command.equals("Home")){
            if (command.equals("back")){
                if (sites.size()<=1){
                    System.out.println("no previous URLs");
                }else{
                    next.push(sites.pop());
                    System.out.println(sites.peek());
                }

            }else if (command.equals("forward")){
                if (next.size()==0){
                    System.out.println("no next URLs");
                }else{
                    sites.push(next.peek());
                    System.out.println(next.pop());
                }
            }else{
                sites.push(command);
                System.out.println(command);
                next.clear();
            }
            command= scanner.nextLine();
        }
    }
}
