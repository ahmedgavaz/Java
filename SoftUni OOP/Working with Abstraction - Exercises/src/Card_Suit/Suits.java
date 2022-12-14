package Card_Suit;

public enum Suits {
    CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);
    int value;

    Suits(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
