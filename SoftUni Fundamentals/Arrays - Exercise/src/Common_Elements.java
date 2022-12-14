import java.util.Scanner;

public class Common_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array1 = scanner.nextLine().split(" ");
        String[] array2 = scanner.nextLine().split(" ");
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i].equals(array2[j])) {
                    System.out.print(array2[j] + " ");
                    break;
                }
            }
        }
        /*for (String word2:array2)
        {   for (String word1:array1)
            {
                if (word2.equals(word1)){
                    System.out.print(word2+" ");
                }
            }
        }*/
    }
}
