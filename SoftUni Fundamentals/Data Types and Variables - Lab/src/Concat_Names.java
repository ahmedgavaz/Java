import java.util.Scanner;

public class Concat_Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name1= scanner.nextLine();
        String name2= scanner.nextLine();
        String sign = scanner.nextLine();
        System.out.println(name1+sign+name2);
    }
}
