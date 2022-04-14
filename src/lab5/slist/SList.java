package lab5.slist;

public class SList <E> {
    SNode<E> head, tail;
    private static Integer size = 0;

    public SList() {
        size = 0;
    }

    // Append a new element at the end of the list.
    public void appendEnd(E e){
        if(size == 0){
            SNode<E> newElement = new SNode<>();
            newElement.element = e;
            head = tail = newElement;
            size++;
        } else if(size == 1){
            SNode<E> newHead = head;
            SNode<E> newElement = new SNode<>();
            newElement.element = e;

            newHead.next = newElement;
            newElement.next = null;
            tail = newElement;
            head = newHead;
            size++;
        }
        else {
            SNode<E> oldTail = tail;
            SNode<E> newElement = new SNode<>();
            newElement.element = e;

            oldTail.next = newElement;
            newElement.next = null;
            tail = newElement;
            size++;
        }
    }

    // Eliminate the first element in the list.
    public E removeInitial(){
        if(size == 0){
            SNode<E> oldHead = head;
            clear();
            return oldHead.element;
        }else{
            SNode<E> oldHead = head;
            head = oldHead.next;
            size--;
            return oldHead.element;
        }
    }

    // Search for an element and returns true if this list contains the searched element
    public boolean contains(E e){
        SNode<E> pointer = head;
        for (int i = 0; i < size; i++) {
            if(pointer.element.equals(e))
                return true;
            pointer = pointer.next;
        }

        return false;
    }

    // Empty all elements in the list and return a statement that reports that the list is
    // empty.
    public void clear(){
        head = tail = null;
        size = 0;
        System.out.println("List has been cleared as size of the list is now " + size);
    }

    // Display all values from the list in a successive order.
    public void display(){
        SNode<E> pointer = head;

        if(size == 0){
            System.out.println("List is empty.");
        }
        else if (size == 1){
            System.out.print("\n[" + head.element + "]\n");
         }
        else {
            System.out.print("\n[" + pointer.element);
            pointer = pointer.next;

            for (int i = 0; i < size-2; i++) {
                System.out.print(" -> " + pointer.element);
                pointer = pointer.next;
            }

            System.out.print(" -> " + tail.element + "]\n");
        }
    }

}
