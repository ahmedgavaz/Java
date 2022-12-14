import java.util.Scanner;

public class Password_Validator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (!numChar(password)){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!consisting(password)){
            System.out.println("Password must consist only of letters and digits");
        }
        if (!digits(password)){
            System.out.println("Password must have at least 2 digits");
        }
        if (numChar(password) && consisting(password) && digits(password)){
            System.out.println("Password is valid");
        }
    }

    public static boolean numChar(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    public static boolean consisting(String password) {
        for (char letter : password.toCharArray()) {
            if (!Character.isLetterOrDigit(letter)) {
                return false;
            }
        }
        return true;
    }

    public static boolean digits(String password) {
        int count = 0;
        for (char letter : password.toCharArray()) {
            if (Character.isDigit(letter)) {
                count++;
            }
        }
        return count > 1;

    }
}
