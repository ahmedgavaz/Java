package ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> items;
    int index;

    public ListyIterator(String... elem){
        this.items=new ArrayList<>();
        this.index=0;
            for (int i = 0; i < elem.length; i++) {
                this.items.add(elem[i]);
            }
        }
    public void Move(){
        if (index<items.size()-1){
            index++;
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    public void Print(){
        System.out.println(this.items.get(index));
    }
    public void HasNext(){
        if (index<items.size()-1){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }


    @Override
    public Iterator<String> iterator() {
        return new sth();
    }

    public class sth implements Iterator<String>{
        int ind=0;
        @Override
        public boolean hasNext() {
            if (ind<items.size()){
               return true;
            }else{
                return false;
            }
        }

        @Override
        public String next() {
            if (ind<items.size()){
                return items.get(ind++);
            }
            else return null;
        }
    }
}
