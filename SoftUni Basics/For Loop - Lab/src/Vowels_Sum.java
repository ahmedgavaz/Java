import java.util.Scanner;

public class Vowels_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int sum = 0;
        for (int a = 0; a < text.length();a++)
            switch (text.charAt(a)){
                case 'a':
                    sum = sum+1;
                    break;
                case 'e':
                    sum = sum+2;
                    break;
                case 'i':
                    sum = sum+3;
                    break;
                case 'o':
                    sum = sum+4;
                    break;
                case 'u':
                    sum = sum+5;
                    break;
            }
        System.out.println(sum);
    }
}
