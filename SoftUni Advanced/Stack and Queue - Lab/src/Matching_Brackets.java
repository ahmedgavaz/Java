import java.util.ArrayDeque;
import java.util.Scanner;

public class Matching_Brackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String problem = scanner.nextLine();
        ArrayDeque<Integer> opening = new ArrayDeque<>();
        for (int i = 0; i < problem.length(); i++) {
            if (problem.charAt(i)=='('){
                opening.push(i);
            }else if (problem.charAt(i)==')'){
                System.out.println(problem.substring(opening.pop(),i+1));
            }
        }
    }
}
