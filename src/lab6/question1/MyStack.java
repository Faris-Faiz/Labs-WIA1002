package lab6.question1;

import java.util.ArrayList;

public class MyStack <E> {
    private ArrayList<E> list = new ArrayList<>();

    public void push(E o){
        list.add(o);
    }

    public E pop(){
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public E peek(){
        return list.get(getSize() - 1);
    }

    public int getSize(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString(){
        return "stack: " + list.toString();
    }

    public boolean search(E o){
        return list.contains(o);
    }
}
