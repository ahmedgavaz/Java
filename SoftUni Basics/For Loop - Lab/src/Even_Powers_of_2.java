import java.util.Scanner;

public class Even_Powers_of_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int a = 0;a <= n; a +=2){
            System.out.println(Math.pow(2,a));
        }
    }
}
