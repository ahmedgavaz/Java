import java.util.Scanner;

public class Replace_Repeating_Chars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder(scanner.nextLine());
        for (int i = 0; i < text.length()-1; i++) {
            if (text.charAt(i)==text.charAt(i+1)){
                text.replace(i+1,i+2,"");
                i--;
            }
        }
        System.out.println(text);
    }
}
