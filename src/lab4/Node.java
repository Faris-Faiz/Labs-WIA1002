package lab4;

public class Node <E> {
    E element;
    Node next;
    static Integer size = 0;

    public Node(E element, Node next) {
        this.element = element;
        this.next = next;
    }

    public Node() {

    }
}
