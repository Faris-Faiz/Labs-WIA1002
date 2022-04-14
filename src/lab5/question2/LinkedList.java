package lab5.question2;

import lab5.slist.SNode;

public class LinkedList <E> {
    Node<E> head, tail;
    static Integer size = 0;

    public LinkedList() {
        size = 0;
    }

    public void add(E e){
        Node<E> newNode = new Node<>();
        newNode.element = e;

        if(size == 0){
            head = tail = newNode;
        } else if(size == 1) {
            Node<E> newHead = head;
            newHead.next = newNode;
            head = newHead;
            tail = newNode;
        } else {
            Node<E> oldTail = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void removeElement(E e){
        if(contains(e) && size == 1){
            head = tail = null;
            System.out.println("Removed " + e);
        }

        if(contains(e)){
            Integer index = indexOf(e);
            if(index == -1){
                System.out.println("The list doesn't contain the name you entered!");
            }else {
                Node<E> beforeElement = head;
                Node<E> currentElement = head;

                for (int i = 0; i < index; i++) {
                    currentElement = currentElement.next;
                }

                for (int i = 0; i < index-1; i++) {
                    beforeElement = beforeElement.next;
                }

                beforeElement.next = beforeElement.next.next;

                System.out.println("Removed " + currentElement.element);
            }
        }else {
            System.out.println("The list doesn't contain the name you entered!");
        }
        size--;
    }

    public void printList(){
        Node<E> pointer = head;

        if(size == 0){
            System.out.println("List is empty.");
        }
        else if (size == 1){
            System.out.print(head.element + "\n");
        }
        else {
            System.out.print("" + pointer.element);
            pointer = pointer.next;

            for (int i = 0; i < size-2; i++) {
                System.out.print(", " + pointer.element);
                pointer = pointer.next;
            }

            System.out.print(", " + tail.element + ".\n");
        }
    }

    public int getSize(){
        return size;
    }

    public boolean contains(E e){
        Node<E> pointer = head;
        for (int i = 0; i < size; i++) {
            if(pointer.element.equals(e)){
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    public void replace(E e, E newE){
        Node<E> pointer = head;

        for (int i = 0; i < size; i++) {
            if (pointer.element.equals(e)){
                pointer.element = newE;
            }
            pointer = pointer.next;
        }
    }

    // not in the question
    public int indexOf(E e) {
        Node<E> currentPosition = head;
        for (int i = 0; i < size; i++){
            if(currentPosition.element.equals(e))
                return i;
            currentPosition = currentPosition.next;
        }
        return -1;
    }
}
