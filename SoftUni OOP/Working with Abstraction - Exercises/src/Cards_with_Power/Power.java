package Cards_with_Power;

public enum Power {
    CLUBS (0), DIAMONDS (13), HEARTS (26), SPADES (39);
    int suit;

    public int getSuit() {
        return suit;
    }

    Power(int suit) {
        this.suit = suit;
    }
}
