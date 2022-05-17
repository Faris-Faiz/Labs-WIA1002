package lab7.question1;
import java.util.Queue;

public class tester {
    public static void main(String[] args) {
        MyQueue<String> fruitQ = new MyQueue<>(new String[] {"Durian", "Blueberry"});
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");

        System.out.println(fruitQ);

        System.out.println("Top of Queue: " + fruitQ.peek());

        System.out.println("Queue size: " + fruitQ.getSize());

        System.out.println("Deleting Durian");

        System.out.println(fruitQ.dequeue());

        System.out.println(fruitQ);

        System.out.println("Item at index position 2: " + fruitQ.getElement(2));

        System.out.println("Contains Cherry? " + fruitQ.contains("Cherry"));

        System.out.println("Contains Durian? " + fruitQ.contains("Durian"));

        while(!fruitQ.isEmpty()){
            System.out.print(fruitQ.dequeue() + " ");
        }

        System.out.println("");
        System.out.println(fruitQ);
        System.out.println("");
    }
}
