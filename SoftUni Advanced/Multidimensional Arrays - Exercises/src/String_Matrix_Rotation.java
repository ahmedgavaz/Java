import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class String_Matrix_Rotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int degree = Integer.parseInt(command.substring(7, command.length() - 1)) % 360;
        String word = scanner.nextLine();
        int maxLength = 0;
        List<String> list = new ArrayList<>();
        while (!word.equals("END")) {
            list.add(word);
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
            word = scanner.nextLine();
        }
        char[][] arr = new char[list.size()][maxLength];
        for (int i = 0; i < list.size(); i++) {
            String wordList = list.get(i);
            if (wordList.length() == maxLength) {
                for (int j = 0; j < maxLength; j++) {
                    arr[i][j] = wordList.charAt(j);
                }
            } else {
                for (int j = 0; j < wordList.length(); j++) {
                    arr[i][j] = wordList.charAt(j);
                }
                for (int j = wordList.length(); j < maxLength; j++) {
                    arr[i][j] = ' ';
                }
            }
        }
        switch (degree) {
            case 0:
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[0].length; j++) {
                        System.out.print(arr[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int i = 0; i < arr[0].length; i++) {
                    for (int j = arr.length - 1; j >= 0; j--) {
                        System.out.print(arr[j][i]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int i = arr.length - 1; i >= 0; i--) {
                    for (int j = arr[0].length - 1; j >= 0; j--) {
                        System.out.print(arr[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int i = arr[0].length - 1; i >= 0; i--) {
                    for (int j = 0; j < arr.length; j++) {
                        System.out.print(arr[j][i]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}

