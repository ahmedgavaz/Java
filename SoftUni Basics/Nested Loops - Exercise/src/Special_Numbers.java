import java.util.Scanner;

public class Special_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1111; i <= 9999; i++) {
            String st = "" + i;
            boolean bol = true;
            for (int j = 0; j < st.length(); j++) {
                int number = Integer.parseInt("" + st.charAt(j));
                if (number == 0 || n % number > 0) {
                    bol = false;
                }
            }
            if (bol == true) {
                System.out.printf("%d ", i);
            }
        }
    }
}
