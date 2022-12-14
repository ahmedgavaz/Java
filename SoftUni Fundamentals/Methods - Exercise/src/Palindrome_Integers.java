import java.util.Scanner;

public class Palindrome_Integers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        while (!number.equals("END")){
            if(palindrome(number)){
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }
            number= scanner.nextLine();
        }
    }
    public static boolean palindrome(String number){
        for (int i = 0; i < number.length()/2; i++) {
            if (!(number.charAt(i)==number.charAt(number.length()-1-i))){
                return false;
            }
        }
        return true;
    }
}
