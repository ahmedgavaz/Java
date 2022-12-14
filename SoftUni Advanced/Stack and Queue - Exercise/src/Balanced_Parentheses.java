import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Balanced_Parentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ArrayDeque<Character> open = new ArrayDeque<>();
        boolean bol = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                open.push(str.charAt(i));
            } else {
                if (open.size() == 0) {
                    bol = false;
                    break;
                }
                char a=open.pop();
                if (str.charAt(i) == ')' && a == '(') {
                }
                if (str.charAt(i) == '}' && a == '{') {
                }
                if (str.charAt(i) == ']' && a == ']') {
                } else if ((str.charAt(i) != ')' && a == '(') || (str.charAt(i) != '}' && a == '{') || (str.charAt(i) != ']' && a == ']')) {
                    bol = false;
                    break;
                }
            }
        }
        if (open.size() > 0) {
            bol = false;
        }
        if (bol) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
