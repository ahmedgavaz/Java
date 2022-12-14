package christmasPastryShop.entities.cocktails.interfaces;

public class Hibernation extends BaseCocktail{

    private final static double hibernationPrice = 4.50;
    public Hibernation(String name, int size, String brand) {
        super(name, size, hibernationPrice, brand);
    }
}
