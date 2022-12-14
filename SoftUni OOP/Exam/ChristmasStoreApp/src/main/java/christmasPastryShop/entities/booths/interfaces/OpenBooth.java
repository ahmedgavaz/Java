package christmasPastryShop.entities.booths.interfaces;

public class OpenBooth extends BaseBooth{
    private final static double pricePerPerson = 2.50;
    public OpenBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, pricePerPerson);
    }
}
