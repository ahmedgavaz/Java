import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);
        // List<Integer> row = new ArrayList<>(n);
        List<List<Integer>> row = new ArrayList<>(m * n);
        //int[][] arr = new int[n][m];
        int number = 1;
        for (int i = 0; i < n; i++) {
            row.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                //  arr[i][j] = number;
                row.get(i).add(number);
                number++;
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] commands = command.split("\\s+");
            int rows = Integer.parseInt(commands[0]);
            int columns = Integer.parseInt(commands[1]);
            int radius = Integer.parseInt(commands[2]);
            if (commands.length == 3) {
                for (int i = row.size() - 1; i >= 0; i--) {
                    for (int j = row.get(i).size() - 1; j >= 0; j--) {
                        if ((i <= rows + radius && i >= rows - radius) && (j <= columns + radius && j >= columns - radius) && (i == rows || j == columns)) {
                            row.get(i).remove(j);
                        }
                    }
                    row.removeIf(List::isEmpty);
                }
            }
            command = scanner.nextLine();
        }
        for (List<Integer> temp : row) {
            for (Integer temporary : temp) {
                System.out.print(temporary + " ");
            }
            System.out.println();
        }
    }
}
