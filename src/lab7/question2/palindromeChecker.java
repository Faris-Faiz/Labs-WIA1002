package lab7.question2;

import lab7.question1.MyQueue;
import java.util.Scanner;

public class palindromeChecker {
    public static void main(String[] args) {
        MyQueue<Character> q = new MyQueue<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String inputString = in.nextLine();
        for (int i = inputString.length()-1; i > -1; i--) {
            q.enqueue(inputString.charAt(i));
        }

        String reverseString = "";

        while(!q.isEmpty()){
            reverseString = reverseString + q.dequeue();
        }

        if(reverseString.equals(inputString)){
            System.out.println("The string is a palindrome");
        }else {
            System.out.println("The string is not a palindrome");
        }
    }
}
