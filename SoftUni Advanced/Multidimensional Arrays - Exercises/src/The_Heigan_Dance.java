import java.util.Scanner;

public class The_Heigan_Dance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double heigan = 3000000;
        int player = 18500;
        int[][] arr = new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                arr[i][j] = 0;
            }
        }
        String spell = "";
        int currentRow = 7;
        int currentColumn = 7;
        double damage = Double.parseDouble(scanner.nextLine());
        while (true) {
            if (player >= 0) {
                heigan -= damage;
            }
            if (spell.equals("Cloud")) {
                player -= 3500;
            }
            if (heigan <= 0 || player <= 0) {
                break;
            }
            String[] attack = scanner.nextLine().split("\\s+");
            int a = Integer.parseInt(attack[1]);
            int b = Integer.parseInt(attack[2]);
            String currentSpell = attack[0];
            if (isDamage(currentRow, currentColumn, a, b)) {
                if (currentRow > 0 && !isDamage(currentRow - 1, currentColumn, a, b)) {
                    currentRow = currentRow - 1;
                    spell = "";
                } else if (currentColumn < 14 && !isDamage(currentRow, currentColumn + 1, a, b)) {
                    currentColumn = currentColumn + 1;
                    spell = "";
                } else if (currentRow < 14 && !isDamage(currentRow + 1, currentColumn, a, b)) {
                    currentRow = currentRow + 1;
                    spell = "";
                } else if (currentColumn > 0 && !isDamage(currentRow, currentColumn - 1, a, b)) {
                    currentColumn = currentColumn - 1;
                    spell = "";
                } else {
                    if (currentSpell.equals("Cloud")) {
                        spell = "Cloud";
                        player -= 3500;
                    } else if (currentSpell.equals("Eruption")) {
                        player -= 6000;
                        spell = "Eruption";
                    }
                }
            }
        }
        if (heigan <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heigan);
        }
        if (player <= 0) {
            if (spell.equals("Cloud")) {
                System.out.println("Player: Killed by Plague Cloud");
            } else {
                System.out.println("Player: Killed by Eruption");
            }
        } else {
            System.out.println("Player: " + player);
        }
        System.out.println("Final position: " + currentRow + ", " + currentColumn);
    }

    private static boolean isDamage(int currentRow, int currentColumn, int a, int b) {
        return currentRow >= a - 1 && currentColumn >= b - 1 && currentRow <= a + 1 && currentColumn <= b + 1;
    }
}