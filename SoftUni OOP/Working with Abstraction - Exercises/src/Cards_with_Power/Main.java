package Cards_with_Power;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
     String str1 = scanner.nextLine();
     String str2 = scanner.nextLine();
     Power power = Power.valueOf(str2);
     Cards cards = Cards.valueOf(str1);
     System.out.printf("Card name: %s of %s; Card power: %d",str1,str2,power.getSuit()+cards.getPower());
    }
}
