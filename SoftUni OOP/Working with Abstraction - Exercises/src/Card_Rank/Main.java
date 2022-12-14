package Card_Rank;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Card Ranks:%n");
        Rank[] ranks = Rank.values();
        for (Rank elem:ranks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",elem.getRank(),elem);
        }
    }
}
