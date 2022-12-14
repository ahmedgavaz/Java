import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String deleting = scanner.nextLine();
        String text = scanner.nextLine();
        while (text.contains(deleting)){
            text = text.replace(deleting,"");
        }
        System.out.println(text);
    }
}
