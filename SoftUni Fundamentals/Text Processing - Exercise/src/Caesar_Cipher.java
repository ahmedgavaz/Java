import java.util.Scanner;
import java.util.zip.CheckedInputStream;

public class Caesar_Cipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String crypt = scanner.nextLine();
        StringBuilder encrypt =new StringBuilder();
        for (int i = 0; i < crypt.length(); i++) {
            int letter = crypt.charAt(i)+3;
            encrypt.append(Character.toChars(letter));
        }
        System.out.println(encrypt);
    }
}
