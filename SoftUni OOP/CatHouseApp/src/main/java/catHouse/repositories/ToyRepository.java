package catHouse.repositories;

import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository{
    private Collection<Toy> toys;

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        return toys.remove(toy);
    }

    @Override
    public Toy findFirst(String type) {
        Toy found=null;
        for (Toy toy:toys) {
            if (toy.getSoftness()==1 && type.equals("Ball")){
                found=toy;
                break;
            }
            if (toy.getSoftness()==5 && type.equals("Mouse")){
                found=toy;
                break;
            }
        }
        return found;
    }
}
