package lab5.question3;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        System.out.println("Adding: 1");
        integerDoublyLinkedList.addFirst(1);

        System.out.println("Adding: 100");
        integerDoublyLinkedList.addLast(100);

        System.out.println("Adding: 2, at position 2");
        integerDoublyLinkedList.add(2, 2);

        System.out.println("Deleted: " + integerDoublyLinkedList.remove(3) + " which is at index 3\n");

        integerDoublyLinkedList.iterateForward();
        integerDoublyLinkedList.iterateBackward();

        System.out.println("\nCurrent size of Doubly Linked List: " + integerDoublyLinkedList.getSize());

        System.out.println("\nSuccessfully clear " + integerDoublyLinkedList.getSize() + " node(s)");
        integerDoublyLinkedList.clear();

        System.out.println("\nCurrent size of Doubly Linked List: " + integerDoublyLinkedList.getSize());
    }
}
