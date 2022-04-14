package lab5.question3;

public class DoublyLinkedList <E> {
    private Node<E> head, tail;
    private Integer size;

    public DoublyLinkedList() {
        size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addFirst(E element){
        Node<E> newElement = new Node<>(element);
                                // if there is a head, then the previous attribute of the head should be the new element
        if(head != null){
            head.previous = newElement;
        }
        else if(tail == null){  // for a case where the list is empty, the new node is both head and tail
            tail = newElement;
        }
        head = newElement;
        size++;
    }

    public void addLast(E element){
        Node<E> newElement = new Node<>(element, null, tail); // adding last, so previous node should be tail.
        if(tail != null){
            tail.next = newElement;
        }
        if(head == null){ // if list is empty
            head = newElement;
        }
        tail = newElement;
        size++;
    }

    public void add(int index, E element){
        if(index < 0 || index > size){
            System.out.println("Can't add!");
        }
        else if(index == 0){
            addFirst(element);
        }
        else if(index == size){
            addLast(element);
        }
        else{
            Node<E> pointer = head;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next; // to make pointer the current element at the desired index
            }
            Node<E> newElement = new Node<>(element, pointer, pointer.previous); // will push the old element (pointer) back in the list
            pointer.previous.next = newElement; // the previous element at the current index's next property becomes the new element
            pointer.previous = newElement; // pushing back the old element at desired index back
            size++;
        }
    }

    public void iterateForward(){
        System.out.println("Iterating forward..");
        Node<E> pointer = head;
        while (pointer != null){
            System.out.print(pointer.element + " ");
            pointer = pointer.next;
        }
        System.out.println("");
    }

    public void iterateBackward(){
        System.out.println("Iterating backward..");
        Node<E> pointer = tail;
        while (pointer != null){
            System.out.print(pointer.element + " ");
            pointer = pointer.previous;
        }
        System.out.println("");
    }

    public E removeFirst(){
        if(size == 0){
            System.out.println("List is empty!");
            return null;
        }else {
            Node<E> temporaryHead = head;
            head = head.next;
            head.previous = null;
            size--;
            return temporaryHead.element;
        }
    }

    public E removeLast(){
        if(size == 0){
            System.out.println("List is empty!");
            return null;
        }else {
            Node<E> temporaryTail = tail;
            tail = tail.previous; // setting new tail
            tail.next = null; // because tails cannot have a next property
            size--;
            return temporaryTail.element;
        }
    }

    public E remove(int index){
        E element = null;
        if(index == 0){
            System.out.println("List is empty!");
            return null;
        }
        else if(index == 1){
            element = removeFirst();
        }
        else if(index == size-1){
            element = removeLast();
        }
        else if(index < 0 || index > size-1){
            System.out.println("We can't do that!");
        }
        else {
            Node<E> pointer = head;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next;
            }
            element = pointer.element;
            pointer.next.previous = pointer.previous; // imagine A B C, remove B, becomes A C, so we make C's previous
                                                      // property become B's previous property which is A.
            pointer.previous.next = pointer.next;     // imagine A B C, remove B, becomes A C, so we make A's next
                                                      // property become B's next property which is C.
            pointer.next = null;                      // remove current element's next property
            pointer.previous = null;                  // remove current element's previous property
            size--;                                   // decrease size, picked up by garbage collector
        }
        return element;
    }

    public void clear(){
        Node<E> death = head;
        while(death != null){
            death = head.next;
            head.previous = head.next = null;
            head = death;
        }
        death = null;
        tail.previous = tail.next = null;
        size = 0;
    }

    public Integer getSize() {
        return size;
    }
}
