import java.util.Scanner;

public class Rally_Racing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();
        Character[][] matrix = new Character[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            String[] str = scanner.nextLine().split(" ");
            for (int j = 0; j < sizeOfMatrix; j++) {
                matrix[i][j] = str[j].charAt(0);
            }
        }
        int row = 0;
        int column = 0;
        boolean bol = false;
        int distance = 0;
        matrix[0][0]='C';
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("End")) {
                break;
            }
            matrix[row][column]='.';
            switch (command) {
                case "up":
                    if (matrix[row - 1][column] == 'T') {
                        matrix[row-1][column]='.';
                        for (int i = 0; i < sizeOfMatrix; i++) {
                            for (int j = 0; j < sizeOfMatrix; j++) {
                                if (i==row - 1 && j==column){
                                    continue;
                                }
                                if (matrix[i][j]=='T'){
                                    row=i;
                                    column=j;
                                    distance+=30;
                                }
                            }
                        }
                        matrix[row][column]='.';
                    }else{
                    row--;
                    distance+=10;}
                    break;
                case "down":
                    if (matrix[row + 1][column] == 'T') {
                        matrix[row+1][column]='.';
                        for (int i = 0; i < sizeOfMatrix; i++) {
                            for (int j = 0; j < sizeOfMatrix; j++) {
                                if (i==row + 1 && j==column){
                                    continue;
                                }
                                if (matrix[i][j]=='T'){
                                    row=i;
                                    column=j;
                                    distance+=30;
                                }
                            }
                        }
                        matrix[row][column]='.';
                    }else{
                        row++;
                    distance+=10;}
                    break;
                case "left":
                    if (matrix[row][column-1] == 'T') {
                        matrix[row][column-1]='.';
                        for (int i = 0; i < sizeOfMatrix; i++) {
                            for (int j = 0; j < sizeOfMatrix; j++) {
                                if (i==row  && j==column-1){
                                    continue;
                                }
                                if (matrix[i][j]=='T'){
                                    row=i;
                                    column=j;
                                    distance+=30;
                                }
                            }
                        }
                        matrix[row][column]='.';
                    }else{
                        column--;
                    distance+=10;}
                    break;
                case "right":
                    if (matrix[row][column+1] == 'T') {
                        matrix[row][column+1]='.';
                        for (int i = 0; i < sizeOfMatrix; i++) {
                            for (int j = 0; j < sizeOfMatrix; j++) {
                                if (i==row  && j==column+1){
                                    continue;
                                }
                                if (matrix[i][j]=='T'){
                                    row=i;
                                    column=j;
                                    distance+=30;
                                }
                            }
                        }
                        matrix[row][column]='.';
                    }else{
                        column++;
                        distance+=10;}
                    break;
            }
            if (matrix[row][column]=='F'){
                bol=true;
                matrix[row][column]='C';
                break;
            }
            matrix[row][column]='C';
        }
        if (bol){
            System.out.printf("Racing car %s finished the stage!%n",racingNumber);
            System.out.printf("Distance covered %d km.%n",distance);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
        else{
            System.out.printf("Racing car %s DNF.%n",racingNumber);
            System.out.printf("Distance covered %d km.%n",distance);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}
