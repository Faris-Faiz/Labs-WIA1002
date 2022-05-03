package lab6.question2;
import lab6.question1.MyStack;

import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        MyStack<Integer> integerMyStack = new MyStack<>();
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        int inputNumber = keyboard.nextInt();

        for (int i = 1; i < inputNumber + 1; i++) {
            integerMyStack.push(i);
        }

        System.out.println("Size of stack: " + integerMyStack.getSize());

        while (!integerMyStack.isEmpty()){
            System.out.println(integerMyStack);
            integerMyStack.pop();
        }
    }
}
