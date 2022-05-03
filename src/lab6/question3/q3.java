package lab6.question3;
import lab6.question1.MyStack;

public class q3 {
    public static void main(String[] args) {
        MyStack<Integer> integerMyStack = new MyStack<>();
        integerMyStack.push(3);
        integerMyStack.push(3);
        integerMyStack.push(3);

        int sum = 0;

        while (!integerMyStack.isEmpty()){
            sum+= integerMyStack.pop();
        }

        System.out.println("Sum of stack: " + sum);
    }
}
