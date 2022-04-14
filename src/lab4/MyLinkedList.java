package lab4;

import java.util.Random;

public class MyLinkedList <E> implements MyLinkedListAbstract<E> {
    Node<E> head, tail;

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        System.out.println("Append the following : a, b, c, d, e");
        myLinkedList.addFirst("e");myLinkedList.addFirst("d");myLinkedList.addFirst("c");myLinkedList.addFirst("b");myLinkedList.addFirst("a");

        System.out.println("Print all the elements in the list.");
        myLinkedList.print();

        System.out.println("\n\nReverse all the elements in the list.");
        myLinkedList.reverse();
        myLinkedList.print();

        System.out.println("\n\nRetrieve the number of elements in the list.");
        System.out.println("Size of list: " + Node.size);

        System.out.println("\n\nRetrieve the first and last value.");
        System.out.println("First value: " + myLinkedList.getFirst());
        System.out.println("Last Value: " + myLinkedList.getLast());

        System.out.println("\n\nDelete the middle value.");
        System.out.println("Before deletion:");
        myLinkedList.print();
        System.out.println("\nAfter deletion:");
        myLinkedList.remove((Node.size - 1) / 2);
        myLinkedList.print();
        System.out.println();

        System.out.println("\n\nRetrieve the index location for the second and third value.");
        System.out.println("Second value: " + myLinkedList.get(1));
        System.out.println("Third value: " + myLinkedList.get(2));

        System.out.println("\nChecks if the list has the value ‘c’.");
        System.out.println(myLinkedList.contains("c"));

        System.out.println("\nReplace the items individually with the following: h,e,l,l,o.");
        myLinkedList.clear();
        myLinkedList.add(0, "h");
        myLinkedList.add(1, "e");
        myLinkedList.add(2, "l");
        myLinkedList.add(3, "l");
        myLinkedList.add(4, "o");
        myLinkedList.print();
    }

    public MyLinkedList() {
        Node.size = 0;
    }

    public void addFirst(E e){ // adding a new node and automatically setting it as the head
        Node<E> newNode = new Node<>(); // creating a new node to add the element to our current linkedlist
        newNode.element = e; // adding the element, IMPORTANT!
        newNode.next = head; // setting our new node's next property as the previous head

        head = newNode; // IMPORTANT! setting the head as our current new node
        Node.size++; // IMPORTANT! must also increase size if we adjust anything to the linked list
        if(tail == null){
            tail = head; // if there is no tail, meaning there are no elements in the linkedlist, therefore the head is also the tail (the only element present in there)
        }
    }

    public void addLast(E e){
        if(tail == null){ // means there's only one element in the list
            Node<E> newNode = new Node<>();
            newNode.element = e;
            newNode.next = null;

            head = tail = newNode; // because the head is also the tail
        }
        else{
            Node<E> newNode = new Node<>();
            newNode.element = e;

            tail.next = newNode;
            tail = tail.next;
        }
        Node.size++;
    }

    public void add(int index, E e){
        if(index==0){
            addFirst(e);
        }
        else if(index >= Node.size){
            addLast(e);
        }else {
            Node<E> newNode = new Node<>();
            newNode.element = e;
            newNode.next = null;

            Node<E> currentElement = head;
            for (int i = 0; i < index-1; i++)
                currentElement = currentElement.next;
            newNode.next = currentElement.next;
            currentElement.next = newNode;
        }
        Node.size++;
    }

    public E removeFirst(){
        if(Node.size == 0){
            return null;
        }

        Node<E> temp = head; // to temporarily hold the value of the current head
        head = head.next; // replace the current head with the node associated with the next value of the head
        Node.size--; // reduce the size of the linked list
        return temp.element; // returns the value of the element to indicate the user what they removed
    }

    public E removeLast(){
        if(Node.size == 0){
            return null;
        }
        else if(Node.size == 1){
            Node<E> temp = tail; // temporarily hold the value of tail to show the user what they removed
            head = tail = null;
            Node.size = 0; // reset the size of the linked list
            return temp.element; // return the removed element to inform the user what they removed
        } else {
            Node<E> currentNode = head;
            for (int i = 0; i < Node.size - 2; i++)  // to stop right before the tail
                currentNode = currentNode.next;
            Node<E> temp = tail; // copy the tail to temp for user's reference
            tail = currentNode; // disintegrate the mantan node
            tail.next = null; // because for it to be a tail, the next must be null ALWAYS
            Node.size--;
            return temp.element;
        }
    }

    public E remove(int index){
        if(index < 0 || index >= Node.size) return null;
        else if(index == 0 ) return removeFirst();
        else if(index == Node.size - 1) return removeLast();

        else{
            Node<E> previous = head; // for traversing purposes
            for (int i = 0; i < index - 1; i++) { // stop right before the desired node to be removed
                previous = previous.next;
            }
            Node<E> current = previous.next; // to be the current index that is desired to be removed
            previous.next = current.next; // to set the previous element's next property to be the next of the current element
            Node.size--; // reduces the size of the list
            return current.element; // returns the element that we removed
        }
    }

    @Override
    public void add(E e) {
        Random rd = new Random();
        Integer index = rd.nextInt(Node.size);
        System.out.println("Added at index: " + index);
        add(index, e);
    }

    @Override
    public boolean contains(E e) {
        Node<E> currentPosition = head;
        for (int i = 0; i < Node.size; i++){
            if(currentPosition.element.equals(e))
                return true;
            currentPosition = currentPosition.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index > Node.size){
            return null;
        }
        if(index == 0){
            return head.element;
        } else if(index == Node.size-1){
            return tail.element;
        }
        Node<E> currentPosition = head;
        for (int i = 0; i < index; i++){
            currentPosition = currentPosition.next;
        }
        return currentPosition.element;
    }

    @Override
    public E getFirst() {
        if(head == null){
            return null;
        }
        return head.element;
    }

    @Override
    public E getLast() {
        if(tail == null){
            return null;
        }
        return tail.element;
    }

    @Override
    public int indexOf(E e) {
        Node<E> currentPosition = head;
        for (int i = 0; i < Node.size; i++){
            if(currentPosition.element.equals(e))
                return i;
            currentPosition = currentPosition.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        Node<E> currentPosition = head;
        int count = 0;
        int index = -1;

        for (int i = 0; i < Node.size; i++) {
            if(currentPosition.element.equals(e))
                index = count;
            count++;
            currentPosition = currentPosition.next;
        }
        return index;
    }

    @Override
    public E set(int index, E e) {
        Node<E> newNode = new Node<>();
        newNode.element = e;
        newNode.next = null;

        if(index == 0){
            Node<E> temp = head;
            head.element = e;
            return temp.element;
        }

        Node<E> previousNode = head;
        for (int i = 0; i < index - 1; i++) {
            previousNode = previousNode.next;
        }

        Node<E> currentPosition = head;
        for (int i = 0; i < index; i++) {
            currentPosition = currentPosition.next;
        }

        Node<E> temp = currentPosition;
        newNode.next = currentPosition.next;
        previousNode.next = newNode;
        currentPosition = newNode;
        return temp.element;
    }

    @Override
    public void clear() {
        Node<E> currentPosition;
        while (head != null){
            currentPosition = head.next;
            head.next = null;
            head = currentPosition;
        }
        tail = null;
        head = null;
        Node.size = 0;
    }

    public void print(){
        if(head == null){
            System.out.println("The list is empty");
        } else {
            Node<E> current = head; // pointer for current head as reference
            System.out.print("[" + current.element + " -> "); // already expecting the head to be printed out
            current = current.next; // move on to the next element in the list

            while (current.next!=null){ // whilst the element has a next element, if it's null, it's definitely the tail
                System.out.print(current.element + " -> ");
                current = current.next;
            }
            System.out.print(current.element + "]"); // expecting the tail
        }
    }

    @Override
    public void reverse() {
        Node<E> prev = null;
        Node<E> current = head;
        Node<E> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        tail = head;
        head = prev;
    }

    public E getMiddleValue(){
        Node<E> midpointElement = new Node<>();
        int midpoint = 0;
        if(Node.size%2 == 0){
            midpoint = Node.size/2;
            midpointElement.element = get(midpoint);
        }else {
            midpoint = (Node.size + 1)/2;
            midpointElement.element = get(midpoint);
        }
        return midpointElement.element;
    }
}