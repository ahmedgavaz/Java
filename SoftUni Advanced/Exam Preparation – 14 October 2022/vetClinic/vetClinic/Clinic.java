package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {

        Pet pet = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).getAge() > pet.getAge()) {
                pet = data.get(i);
            }
        }
        return pet;
    }

    public int getCount() {
        if (data.size() > 0) {
            return data.size();
        } else {
            return 0;
        }
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The clinic has the following patients:");
        for (int i = 0; i < data.size(); i++) {
            stringBuilder.append(System.lineSeparator()).append(data.get(i).getName()).append(" ").append(data.get(i).getOwner());
        }
        return stringBuilder.toString();
    }
}
