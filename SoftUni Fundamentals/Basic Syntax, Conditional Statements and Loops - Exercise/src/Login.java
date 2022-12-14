import java.util.Scanner;
public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password="";
        for (int i=username.length()-1;i>=0;i--){
            char symbol = username.charAt(i);
            password+=symbol;
        }
        boolean bol= false;
        for (int i=1;i<=4;i++){
            String pass = scanner.nextLine();
            if (password.equals(pass)){
                System.out.printf("User %s logged in.",username);
                bol=true;
                break;
            }
            else{
                if (i<4){
                System.out.println("Incorrect password. Try again.");
                }
            }

        }
        if (bol==false){
            System.out.printf("User %s blocked!",username);
        }
    }
}
