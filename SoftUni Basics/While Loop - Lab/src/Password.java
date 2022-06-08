import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String password = scanner.nextLine();
        String password1 = scanner.nextLine();
        while (!password.equals(password1)){
            password1 = scanner.nextLine();
        }
        System.out.println("Welcome " + name + "!");
    }
}
