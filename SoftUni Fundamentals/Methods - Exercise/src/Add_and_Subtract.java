import java.util.Scanner;

public class Add_and_Subtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        sum(n1,n2,n3);
    }

    public static void sum(int n1, int n2, int n3) {
        System.out.println(n1+n2-n3);
    }
}
