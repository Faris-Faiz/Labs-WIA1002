package lab5.slist;

public class SNode<E> {
    E element;
    SNode<E> next;

    public SNode(E element, SNode<E> next) {
        this.element = element;
        this.next = next;
    }

    public SNode(){

    }
}
