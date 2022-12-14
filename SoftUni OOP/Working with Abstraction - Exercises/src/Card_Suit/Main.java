package Card_Suit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        Suits[] cards = Suits.values();
        for (Suits elem:cards) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",elem.getValue(),elem);
        }
    }
}
