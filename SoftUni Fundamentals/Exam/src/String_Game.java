import java.util.Scanner;

public class String_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Done")) {
            String[] commands = command.split("\\s+");
            switch (commands[0]) {
                case "Change":
                    string = string.replace(commands[1], commands[2]);
                    System.out.println(string);
                    break;
                case "Includes":
                    if (string.contains(commands[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    int length = commands[1].length();
                    String substring = string.substring(string.length() - length);
                    if (substring.equals(commands[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    string = string.toUpperCase();
                    System.out.println(string);
                    break;
                case "FindIndex":
                    System.out.println(string.indexOf(commands[1]));
                    break;
                case "Cut":
                    int start = Integer.parseInt(commands[1]);
                    int len = Integer.parseInt(commands[2]);
                    String sub = string.substring(start, start + len);
                    string = sub;
                    System.out.println(string);
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
