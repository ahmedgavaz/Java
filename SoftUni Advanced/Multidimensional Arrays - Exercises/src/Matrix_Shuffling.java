import java.util.Scanner;

public class Matrix_Shuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int a = Integer.parseInt(dimensions[0]);
        int b = Integer.parseInt(dimensions[1]);
        String[][] arr = new String[a][b];
        for (int i = 0; i < a; i++) {
            arr[i] = scanner.nextLine().split("\\s+");
        }
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commands = command.split("\\s+");
            boolean bol = validOperation(commands, arr);
            if (bol) {
                int firstRow = Integer.parseInt(commands[1]);
                int firstColumn = Integer.parseInt(commands[2]);
                int secondRow = Integer.parseInt(commands[3]);
                int secondColumn = Integer.parseInt(commands[4]);
                String temp = arr[firstRow][firstColumn];
                arr[firstRow][firstColumn] = arr[secondRow][secondColumn];
                arr[secondRow][secondColumn] = temp;
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < b; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    private static boolean validOperation(String[] command, String[][] arr) {
        if (command.length != 5) {
            return false;
        }
        if (!command[0].equals("swap")) {
            return false;
        }
        int firstRow = Integer.parseInt(command[1]);
        int firstColumn = Integer.parseInt(command[2]);
        int secondRow = Integer.parseInt(command[3]);
        int secondColumn = Integer.parseInt(command[4]);
        int a = arr.length;
        int b = arr[0].length;
        if (firstColumn < 0 || firstColumn >= b || secondColumn < 0 || secondColumn >= b || firstRow<0 ||firstRow>=a ||secondRow<0 || secondRow>=a) {
            return false;
        }
        return true;
    }
}
