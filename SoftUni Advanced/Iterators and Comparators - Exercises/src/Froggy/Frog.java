package Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Frog implements Iterable<Integer>{
    private List<Integer> list;
    private int index;

    public Frog(){
        this.list=new ArrayList<>();
    }

    public void adding(List<Integer> listing){
        this.list.addAll(listing);
    }
    public Frog(List<Integer> list) {
        this.list.addAll(list);
        if (this.list.size()==0){
            this.index=-1;
        }else{
            index=0;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                if (index%2==1 && index>=list.size()){
                    return false;
                }
                return true;
            }

            @Override
            public Object next() {
                int elem = list.get(index);
                index=index+2;
                if (index%2==0 && index>=list.size()){
                    index=1;
                }
                return elem;
            }
        };
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
