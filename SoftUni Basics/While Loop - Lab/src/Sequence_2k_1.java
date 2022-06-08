import java.util.Scanner;

public class Sequence_2k_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i = i * 2 + 1) {
            System.out.println(i);
        }
    }
}
