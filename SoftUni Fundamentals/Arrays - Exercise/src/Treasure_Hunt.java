import java.util.Scanner;

public class Treasure_Hunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] loots = scanner.nextLine().split("\\|");
        String command = scanner.nextLine();
        while (!command.equals("Yohoho!")) {
            String[] commands = command.split(" ");
            //int len = loots.length;
            switch (commands[0]) {
                case "Loot":
                    for (int i = 1; i < commands.length; i++) {
                        boolean bol = false;
                        for (int j = 0; j < loots.length; j++) {
                            if (commands[i].equals(loots[j])) {
                                bol = true;
                                break;
                            }
                        }
                        if (!bol) {
                            String newChest = commands[i] + " " + String.join(" ", loots);
                            loots = newChest.split(" ");
                        }
                    }
                    break;
                case "Drop":
                    if (Integer.parseInt(commands[1]) >= 0 && Integer.parseInt(commands[1])< loots.length) {
                        String temp = loots[Integer.parseInt(commands[1])];
                        for (int i = Integer.parseInt(commands[1]); i < loots.length - 1; i++) {
                            loots[i] = loots[i + 1];
                        }
                        loots[loots.length - 1] = temp;
                    }else {
                        break;
                    }
                    break;
                case "Steal":
                    if (Integer.parseInt(commands[1]) >= 0 && Integer.parseInt(commands[1]) < loots.length) {
                        String[] stolen = new String[Integer.parseInt(commands[1])];
                        for (int i = loots.length - Integer.parseInt(commands[1]); i < loots.length; i++) {
                            stolen[i - loots.length + Integer.parseInt(commands[1])] = loots[i];
                        }
                        for (int i = 0; i < stolen.length - 1; i++) {
                            System.out.print(stolen[i] + ", ");
                        }
                        System.out.println(stolen[stolen.length - 1]);
                        String[] newChest = new String[loots.length - Integer.parseInt(commands[1])];
                        for (int i = 0; i < loots.length - Integer.parseInt(commands[1]); i++) {
                            newChest[i] = loots[i];
                        }
                        loots = newChest;
                    }
                    else{
                        for (int i = 0; i < loots.length - 1; i++) {
                            System.out.print(loots[i] + ", ");
                        }
                        System.out.println(loots[loots.length - 1]);
                        loots = new String[0];
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        if (loots.length <= 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            String word = String.join("", loots);
            System.out.printf("Average treasure gain: %.2f pirate credits.", (1.0 * word.length()) / loots.length);
        }
    }
}