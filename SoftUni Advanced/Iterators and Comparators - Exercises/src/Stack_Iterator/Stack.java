package Stack_Iterator;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Stack implements Iterable {
    ArrayDeque<Integer> arr = new ArrayDeque<>();

    public Stack(){

    }
    public Stack(int[] array){
        for (int i = 0; i < array.length; i++) {
            arr.push(array[i]);
        }
    }

    public Integer pop(){
        return arr.pop();
    }

    public Integer size(){
        return arr.size();
    }

    public void push(int elem){
         arr.push(elem);
    }

    @Override
    public Iterator iterator() {
        return new sth();
    }

    public class sth implements Iterator<Integer>{
        ArrayDeque<Integer> arrSecond = arr;
        @Override
        public boolean hasNext() {
            if (arrSecond.size()>0){
                return true;
            }else{
                arrSecond=arr;
                return false;
            }
        }

        @Override
        public Integer next() {
            if (arrSecond.size()>0){
                return arrSecond.pop();
            }
            else {
                arrSecond=arr;
                return null;
            }
        }
    }
}
