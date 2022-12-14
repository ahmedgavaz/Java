package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.BaseCocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.List;

public abstract class BaseBooth implements Booth {
    private List<Delicacy> delicacyOrders;
    private List<BaseCocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
    }

    public void reserve(int numberOfPeople){
        if (numberOfPeople<=0){
            throw new IllegalArgumentException("Cannot place zero or less people!");
        }
        this.numberOfPeople = numberOfPeople;
        this.price = numberOfPeople*pricePerPerson;
    }

    public double getBill(){
        double sum=0;
        for (BaseCocktail cocktail:cocktailOrders) {
            sum+=cocktail.getPrice();
        }
        for (Delicacy delicacy:delicacyOrders) {
            sum+=delicacy.getPrice();
        }
        return sum;
    }

    public void clear(){
        delicacyOrders.clear();
        cocktailOrders.clear();
    }

    public List<Delicacy> getDelicacyOrders() {
        return delicacyOrders;
    }

    public void setDelicacyOrders(List<Delicacy> delicacyOrders) {
        this.delicacyOrders = delicacyOrders;
    }

    public List<BaseCocktail> getCocktailOrders() {
        return cocktailOrders;
    }

    public void setCocktailOrders(List<BaseCocktail> cocktailOrders) {
        this.cocktailOrders = cocktailOrders;
    }

    public int getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity<=0){
            throw new IllegalArgumentException("Capacity has to be greater than 0!");
        }
        this.capacity = capacity;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
