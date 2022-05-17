package lab7.question1;

import java.util.LinkedList;

public class MyQueue <E> {
    LinkedList<E> list = new LinkedList<>();


    /**
     * To parse an array of any data type to be converted into a queue
     * @param e to allow for a dynamic array to be parsed into the queue
     */
    public MyQueue(E[] e){
        for (E element : e) {
            enqueue(element);
        }
    }

    /**
     * No-arg constructor for general purpose use
     */
    public MyQueue(){

    }

    /**
     * Uses the LinkedList add method to enqueue elements to the queue, this new element will become the
     * rear of the list
     * @param e the element desired to be enqueued into the queue
     */
    public void enqueue(E e){
        list.add(e);
    }

    /**
     * Uses the removeFirst() method from LinkedList to remove the front element of the list as queues use FIFO
     * (First in, First out) methodology
     * @return the element we removed from the queue for reference by the user
     */
    public E dequeue(){
        return list.removeFirst();
    }

    /**
     * Uses the get() method from LinkedList at the specified index. Two conditions must be met, that is the size
     * must not be less than 0, and the index must not be more then than the size of the queue.
     * @param i the index of the wanted element
     * @return null if the conditions of the if statement is met, else return the element at the specified index
     */
    public E getElement(int i){
        if(list.size()< 0 || i >= list.size()){return null;}
        return list.get(i);
    }

    /**
     * Uses getFirst() method that can be found from LinkedList, as the first method is the front of the queue.
     * @return the first element in the queue, which is the front, which is also the first element we added into the
     * queue
     */
    public E peek(){
        return list.getFirst();
    }

    /**
     * Uses the size() method from LinkedList to retrieve the size of the queue
     * @return an integer of the size of the queue
     */
    public int getSize(){
        return list.size();
    }

    /**
     * uses the contains() method from LinkedList to figure out if the queue contains the desired element
     * @param e the desired element
     * @return True/False if the element exists in the queue
     */
    public boolean contains(E e){
        return list.contains(e);
    }

    /**
     * Uses the size() method from LinkedList to determine if the queue is empty.
     * @return True/False if the size of the element is 0. True if it is 0, false if it isn't equal to 0.
     */
    public boolean isEmpty(){
        return list.size() == 0;
    }

    /**
     * Uses the toString() method from LinkedList to be able to print out the queue in a neat fashion. Overrides the
     * built-in toString() method that normally returns the address of the specific object that you want to print.
     * @return
     */
    public String toString(){
        return list.toString();
    }

    /**
     * To set the first element in the queue to be another element. Useful in niche cases.
     * @param e the desired element that you want to change that is at the front of the queue.
     */
    public void set(E e){
        list.set(0,e);
    }
}
