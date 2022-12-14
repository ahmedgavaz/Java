import java.util.Scanner;

public class Matrix_of_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String[][] arr=new String[a][b];
        char chr = 'a';
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j]=""+chr+(char)(chr+j)+chr;
            }
            chr=(char)(chr+1);
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
