import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());
        for (int i = floors; i >= 1; i--) {
            for (int j = 0; j <= rooms - 1; j++) {
                if (floors == 1) {
                    System.out.printf("L%d%d ", i, j);
                } else {
                    if (i == floors) {
                        System.out.printf("L%d%d ", i, j);
                    } else {
                        if (i % 2 == 1) {
                            System.out.printf("A%d%d ", i, j);
                        } else {
                            System.out.printf("O%d%d ", i, j);
                        }
                    }
                    if (j == rooms - 1) {
                        System.out.println("");
                    }
                }
            }
        }
    }
}
