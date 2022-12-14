import java.util.Scanner;

public class NxN_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        matrix(n);
    }

    public static void row(int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", n);
        }
    }

    public static void matrix(int n) {
        for (int i = 0; i < n; i++) {
            row(n);
            System.out.printf("%n");
        }
    }
}
