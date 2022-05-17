package lab7.question1;

import java.util.LinkedList;

public class MyQueue <E> {
    LinkedList<E> list = new LinkedList<>();

    public MyQueue(E[] e){
        for (E element : e) {
            enqueue(element);
        }
    }

    public MyQueue(){

    }

    public void enqueue(E e){
        list.add(e);
    }

    public E dequeue(){
        return list.removeFirst();
    }

    public E getElement(int i){
        if(list.size()< 0 || i >= list.size()){return null;}
        return list.get(i);
    }

    public E peek(){
        return list.getFirst();
    }

    public int getSize(){
        return list.size();
    }

    public boolean contains(E e){
        return list.contains(e);
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public String toString(){
        return list.toString();
    }

    public void set(E e){
        list.set(0,e);
    }
}
