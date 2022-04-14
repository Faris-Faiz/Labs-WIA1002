package lab5.question2;

public class Node <E> {
    E element;
    Node<E> next;

    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

    public Node() {

    }
}
