import java.util.Scanner;

public class Sum_of_Two_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int beginning = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        boolean bol = true;
        int n = 0;
        for (int i = beginning; i <= end; i++) {
            for (int j = beginning; j <= end; j++) {
                n++;
                if (i + j == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)",n, i, j, i + j );
                    bol = false;
                    return;
                }
            }
        }
        if (bol == true) {
            System.out.println(n + " combinations - neither equals " + magicNumber);
        }
    }
}
