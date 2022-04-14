package lab4;

public interface MyLinkedListAbstract <E> {
    /**
     * Return nothing, but adds an element to the list
     * My implementation: arbitrarily get a number as the index and add it using random class
     * @param e the element to be added into the list
     */
    void add(E e);

    /**
     * Return true if list contains the element e
     * @param e the element to be checked if it exists in the list
     * @return Return true if list contains the element e
     */
    boolean contains(E e);

    /**
     * Return element at the specified index
     * @param index the index of the desired element
     * @return element at the specified index
     */
    E get(int index);

    /**
     * Return the value of the first item
     * @return value of the first item
     */
    E getFirst();

    /**
     * Return the value of the last item
     * @return value of the last item in the list
     */
    E getLast();

    /**
     * Return the index of the head matching element in this
     * list. Return -1 if no match
     * @param e the desired element that you want the index of
     * @return index of the index that matches the parsed element
     */
    int indexOf(E e);

    /**
     * Return the index of the last matching element in this
     * list. Return -1 if no match
     * @param e the desired repeating element that you want the index of
     * @return the last index of the last matching element, that is repeating, in the list
     */
    int lastIndexOf(E e);

    /**
     * Replace the element at the specified position in this
     * list with the specified element
     * @param index the desired index you want to replace because you hate it so much
     * @param e the element you want to replace the mantan element so much man what the hell is wrong witchu
     * @return at the time of writing, not even sure what you want to return, but probably you want
     * to return the old element prior to being replaced.
     */
    E set(int index, E e);

    /**
     * Clears the list, what the hell you want me to write more about?
     */
    void clear();

    /**
     * prints the whole list. Preferably you print out the head with a square bracket, and set the
     * tail to end with a square bracket as well, separated with arrows to indicate the pointers pointing
     * to the other node.
     *
     * Ex:
     * [0 -> 1 -> 2]
     *
     * Why would you want this? You already have it in the MyLinkedList class. But I'll just follow what the question
     * wants man.
     */
    void print();

    /**
     * Prints all the elements in reverse.
     */
    void reverse();
}
