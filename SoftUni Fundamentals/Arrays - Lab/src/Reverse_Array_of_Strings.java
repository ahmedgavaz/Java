import java.util.Scanner;

public class Reverse_Array_of_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] name = scanner.nextLine().split(" ");
        for (int i = 0; i < name.length/2; i++) {
            String temp = name[i];
            name[i]=name[name.length-1-i];
            name[name.length-1-i]=temp;
        }
        System.out.print(String.join(" ",name));
    }
}
