package lab7.question1;

public class QueueNode <E> {
    E key;
    QueueNode<E> next;

    public QueueNode(E key){
        this.key = key;
        this.next = null;
    }
}
