import java.util.Scanner;

public class Town_Info {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        short area = Short.parseShort(scanner.nextLine());
        System.out.printf("Town %s has population of %d and area %d square km.",name,population,area);
    }
}
