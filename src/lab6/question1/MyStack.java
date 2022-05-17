package lab6.question1;

import java.util.ArrayList;

public class MyStack <E> {
    private ArrayList<E> list = new ArrayList<>();

    /**
     * Adds the element into the stack. Uses the add() method from LinkedList to achieve this.
     * @param o the desired element to be added onto the stack
     */
    public void push(E o){
        list.add(o);
    }

    /**
     * Removes the last element on the stack, as the last element on the stack is the top of the stack.
     * You'd need to flip the output into a vertical state to have this make more sense.
     * This is also because Stacks uses Last in, First out (LIFO) methodology, whereby the last element that is added
     * into the stack is the first element to be removed from the stack.
     * Uses the get() method from LinkedList to achieve this, alongside the getSize() method, subtracted with 1 to
     * know the last element of the list (top of the stack)
     * Uses the remove() method from LinkedList to finally achieve the removal of the top of the stack. Removal (pop) and
     * insertion (push) takes at the same place.
     * @return the removed element for reference by the user
     */
    public E pop(){
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    /**
     * Peek is to see what element is at the top of the stack, similar to peek() in queues. However, in queues,
     * they return the first element whereas in stacks, they return the last element as explained prior.
     * Usees the get() method from LinkedList to achieve this, alongside getSize() - 1 to find the last element
     * of the list.
     * @return the last element on the stack, which signifies the top of the list
     */
    public E peek(){
        return list.get(getSize() - 1);
    }

    /**
     * Informs the user of the size of the stack by using the size() method from LinkedList
     * @return an integer of the size of the list
     */
    public int getSize(){
        return list.size();
    }

    /**
     * Uses the .isEmpty() method from LinkedList to achieve this.
     * @return True if the stack is empty, False if the stack is not empty.
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * Overridden method, to avoid printing out addresses of the object when the print function is called in the main
     * method. Also uses the .toString() method from LinkedList to achieve this.
     * @return string representation of the stack, in a more meaningful manner.
     */
    @Override
    public String toString(){
        return "stack: " + list.toString();
    }

    /**
     * Searches for the desired element using the contains() method from the LinkedList class
     * @param o the element in question
     * @return True if the element exists in the stack, False if the element doesn't exist in the stack.
     */
    public boolean search(E o){
        return list.contains(o);
    }
}
