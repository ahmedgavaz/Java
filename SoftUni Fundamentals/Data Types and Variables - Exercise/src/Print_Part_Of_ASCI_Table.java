import java.util.Scanner;

public class Print_Part_Of_ASCI_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int end =Integer.parseInt(scanner.nextLine());
        for (int i = start; i <=end ; i++) {
            System.out.printf("%c ",(char)i);
        }
    }
}
