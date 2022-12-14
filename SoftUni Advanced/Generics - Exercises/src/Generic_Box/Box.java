package Generic_Box;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable> {
    private List<T> box;

    public Box(){
        this.box=new ArrayList<>();
    }

    public void add(T element){
        this.box.add(element);
    }
    @Override
    public String toString(){
        StringBuilder text = new StringBuilder();
        for (T elem:box) {
            text.append(elem.getClass().getName() + ": " + elem + "\n");
        }
        return text.toString();
    }
    public void swap(int index1, int index2){
        T elem1 = this.box.get(index1);
        T elem2 = this.box.get(index2);
        this.box.set(index1,elem2);
        this.box.set(index2,elem1);
    }
    public int count(T element){
        int number=0;
        for (T elem:box) {
            if (elem.compareTo(element)>0){
                number++;
            }
        }
        return number;
    }
}
