import java.util.Scanner;

public class Valid_Usernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernames = scanner.nextLine().split(", ");
        for (String username:usernames) {
            boolean bol=true;
            if (username.length()>15||username.length()<4){
                continue;
            }
            for (int i = 0; i < username.length(); i++) {
                if (!(Character.isLetterOrDigit(username.charAt(i))||username.charAt(i)=='-'||username.charAt(i)=='_')){
                    bol=false;
                    break;
                }
            }
            if (bol==true){
                System.out.println(username);
            }
        }
    }
}
