package lab6.question1;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();
        // Following the given order, add elements, a b and c in the stack.
        stack.push('a');
        stack.push('b');
        stack.push('c');

        // Print the stack.
        System.out.println(stack);

        // Check if element ‘b’ is in the stack.
        System.out.println(stack.search('b'));

        // Check if element ‘k’ is in the stack.
        System.out.println(stack.search('k'));

        // In the same test program as Q1(b), create a second stack of type integer
        MyStack<Integer> anotherStack = new MyStack<>();

        // Following the given order, add elements, 1 2 and 3 in the stack.
        anotherStack.push(1);
        anotherStack.push(2);
        anotherStack.push(3);

        // Print the stack.
        System.out.println(anotherStack);

        // Check if element ‘6’ is in the stack.
        System.out.println(anotherStack.search(6));
    }
}
