import java.util.Scanner;

public class Re_Volt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int commands = Integer.parseInt(scanner.nextLine());
        Character[][] matrix = new Character[n][n];
        boolean bol = false;
        int row = 0;
        int column = 0;
        for (int i = 0; i < n; i++) {
            String field = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = field.charAt(j);
                if (field.charAt(j) == 'f') {
                    row = i;
                    column = j;
                }
            }
        }
        while (commands > 0) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (row == 0) {
                        if (matrix[matrix.length - 1][column] == 'B') {
                            matrix[row][column] = '-';
                            matrix[matrix.length - 2][column] = 'f';
                            row = matrix.length - 2;
                        } else if (matrix[matrix.length - 1][column] == 'T') {
                            continue;
                        } else {
                            matrix[row][column] = '-';
                            matrix[matrix.length - 1][column] = 'f';
                            row = matrix.length - 1;
                        }
                    } else {
                        if (matrix[row - 1][column] == 'B') {
                            if (row == 1) {
                                matrix[row][column] = '-';
                                matrix[matrix.length - 1][column] = 'f';
                                row = matrix.length - 1;
                            } else {
                                matrix[row][column] = '-';
                                matrix[row - 2][column] = 'f';
                                row = row - 2;
                            }
                        } else if (matrix[row - 1][column] == 'T') {
                            continue;
                        } else {
                            matrix[row][column] = '-';
                            matrix[row - 1][column] = 'f';
                            row--;
                        }
                    }
                    break;
                case "down":
                    if (row == matrix.length - 1) {
                        if (matrix[0][column] == 'B') {
                            matrix[row][column] = '-';
                            matrix[1][column] = 'f';
                            row = 1;
                        } else if (matrix[0][column] == 'T') {
                            continue;
                        } else {
                            matrix[row][column] = '-';
                            matrix[0][column] = 'f';
                            row = 0;
                        }
                    } else {
                        if (matrix[row + 1][column] == 'B') {
                            if (row == matrix.length - 2) {
                                matrix[row][column] = '-';
                                matrix[0][column] = 'f';
                                row = 0;
                            } else {
                                matrix[row][column] = '-';
                                matrix[row + 2][column] = 'f';
                                row = row + 2;
                            }
                        } else if (matrix[row + 1][column] == 'T') {
                            continue;
                        } else {
                            matrix[row][column] = '-';
                            matrix[row + 1][column] = 'f';
                            row++;
                        }
                    }
                    break;
                case "left":
                    if (column == 0) {
                        if (matrix[row][matrix[row].length - 1] == 'B') {
                            matrix[row][column] = '-';
                            matrix[row][matrix[row].length - 2] = 'f';
                            column = matrix[row].length - 2;
                        } else if (matrix[row][matrix[row].length - 1] == 'T') {
                            continue;
                        } else {
                            matrix[row][column] = '-';
                            matrix[row][matrix[row].length - 1] = 'f';
                            column = matrix[row].length - 1;
                        }
                    } else {
                        if (matrix[row][column - 1] == 'B') {
                            if (column == 1) {
                                matrix[row][column] = '-';
                                matrix[row][matrix[row].length - 1] = 'f';
                                column = matrix[row].length - 1;
                            } else {
                                matrix[row][column] = '-';
                                matrix[row][column - 2] = 'f';
                                column = column - 2;
                            }
                        } else if (matrix[row][column - 1] == 'T') {
                            continue;
                        } else {
                            matrix[row][column] = '-';
                            matrix[row][column - 1] = 'f';
                            column--;
                        }
                    }
                    break;
                case "right":
                    if (column == matrix[row].length - 1) {
                        if (matrix[row][0] == 'B') {
                            matrix[row][column] = '-';
                            matrix[row][1] = 'f';
                            column = 1;
                        } else if (matrix[row][0] == 'T') {
                            continue;
                        } else {
                            matrix[row][column] = '-';
                            matrix[row][0] = 'f';
                            column = 0;
                        }
                    } else {
                        if (matrix[row][column + 1] == 'B') {
                            if (column == matrix[row].length - 2) {
                                matrix[row][column] = '-';
                                matrix[row][0] = 'f';
                                column = 0;
                            } else {
                                matrix[row][column] = '-';
                                matrix[row][column + 2] = 'f';
                                column = column + 2;
                            }
                        } else if (matrix[row][column + 1] == 'T') {
                            continue;
                        } else {
                            matrix[row][column] = '-';
                            matrix[row][column + 1] = 'f';
                            column++;
                        }
                    }
                    break;
            }
            commands--;
            boolean bool = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 'F') {
                        bool = true;
                    }
                }
            }
            if (bool == false) {
                bol = true;
                break;
            }
        }
        if (bol) {
            System.out.println("Player won!");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Player lost!");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}
