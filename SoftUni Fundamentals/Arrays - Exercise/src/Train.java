import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagons = Integer.parseInt(scanner.nextLine());
        int[] train = new int[wagons];
        int sum=0;
        for (int i = 0; i < wagons; i++) {
            train[i]=Integer.parseInt(scanner.nextLine());
            sum+=train[i];
        }
        for (int wagon:train) {
            System.out.print(wagon + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
