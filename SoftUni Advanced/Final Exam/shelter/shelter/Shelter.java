package shelter;
import java.util.ArrayList;
import java.util.List;
public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity){
        this.capacity=capacity;
        this.data=new ArrayList<>();
    }
    public void add(Animal animal){
        if (data.size()<capacity){
            data.add(animal);
        }
    }

    public boolean remove(String name){
        for (Animal animal:data) {
            if (animal.getName().equals(name)){
                data.remove(animal);
                return true;
            }
        }
        return false;
    }
    public Animal getAnimal(String name, String caretaker) {
        for (Animal animal : data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        Animal animal = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).getAge() > animal.getAge()) {
                animal = data.get(i);
            }
        }
        return animal;
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
        stringBuilder.append("The shelter has the following animals:");
        for (int i = 0; i < data.size(); i++) {
            stringBuilder.append(System.lineSeparator()).append(data.get(i).getName()).append(" ").append(data.get(i).getCaretaker());
        }
        return stringBuilder.toString();
    }
}
