package Pokemon_Trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> collection=new ArrayList<>();

    public Trainer(String name, int numberOfBadges, List<Pokemon> collection) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.collection = collection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getCollection() {
        return collection;
    }

    public void setCollection(List<Pokemon> collection) {
        this.collection = collection;
    }
}
