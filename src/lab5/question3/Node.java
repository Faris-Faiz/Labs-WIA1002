package lab5.question3;

public class Node<E> {
    E element;
    Node<E> next, previous;

    public Node(E element, Node<E> next, Node<E> previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    public Node(E element) { // so that we don't have to constantly set the element in a separate line
        this(element, null, null);
    }
}
