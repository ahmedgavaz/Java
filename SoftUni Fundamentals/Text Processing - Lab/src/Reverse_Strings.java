import java.util.Scanner;

public class Reverse_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while ((!command.equals("end"))){
            String reversed="";
            for (int i = command.length()-1; i >=0 ; i--) {
                reversed = reversed.concat(String.valueOf(command.charAt(i)));
            }
            System.out.printf("%s = %s%n",command,reversed);
            command= scanner.nextLine();
        }
    }
}
