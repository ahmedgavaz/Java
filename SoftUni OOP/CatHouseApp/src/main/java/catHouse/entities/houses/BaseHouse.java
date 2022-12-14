package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House {
    private String name;//Greshkaaaaa Unique name
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;


    public BaseHouse(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int sum = 0;
        for (Toy elem : toys) {
            sum += elem.getSoftness();
        }
        return sum;
    }

    @Override
    public void addCat(Cat cat) {
        if (cats.size() >= capacity) {
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat : cats) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append(" ").append(this.getClass().getSimpleName()).append(":").append(System.lineSeparator());
        stringBuilder.append("Cats: ");
        if (cats.size() == 0) {
            stringBuilder.append("none");
        } else {
            int counter=0;
            for (Cat cat : cats) {
                counter++;
                stringBuilder.append(cat.getName());
                if (counter<cats.size()){
                    stringBuilder.append(" ");
                }
            }
        }
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Toys: ").append(this.toys.size()).append(" Softness: ").append(this.sumSoftness());
        return stringBuilder.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
