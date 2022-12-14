package Custom_List;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable> {
    private List<T> elements;

    public CustomList(){
        this.elements=new ArrayList<>();
    }
    public void add(T element){
        this.elements.add(element);
    }

    public T remove(int index){
        return elements.remove(index);
    }

    public boolean contains(T element){
        return this.elements.contains(element);
    }

    public void swap(int index1, int index2){
        T elem1 = this.elements.get(index1);
        T elem2 = this.elements.get(index2);
        this.elements.set(index1,elem2);
        this.elements.set(index2,elem1);
    }

    public int countGreaterThan(T element){
        int number=0;
        for (T elem:elements) {
            if (elem.compareTo(element)>0){
                number++;
            }
        }
        return number;
    }

    public T getMax(){
        return elements.stream().max((e1,e2)->e1.compareTo(e2)).get();
    }

    public T getMin(){
        return elements.stream().min((e1,e2)->e1.compareTo(e2)).get();
    }
    public void print(){
        elements.stream().forEach(e-> System.out.println(e));
    }
    public void sorting(){
        elements.sort((e1,e2)->e1.compareTo(e2));
    }
}
