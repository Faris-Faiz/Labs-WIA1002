package lab6.question4;
import lab6.question1.MyStack;

import java.util.Scanner;

public class palindromeChecker {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        MyStack<Character> characterMyStack = new MyStack<>();
        boolean go = true;

        while (go){
            System.out.print("Please input the string: ");
            String inputString = keyboard.nextLine();
            if(inputString.length() < 16){
                go = false;

                char[] tempCharArray = inputString.toCharArray();

                for(int i = 0; i < tempCharArray.length; i++){
                    characterMyStack.push(tempCharArray[i]);
                }

                String reverseString = "";

                while(!characterMyStack.isEmpty()){
                    reverseString += characterMyStack.pop();
                }

                if(reverseString.equals(inputString)){
                    System.out.println("The inputted string is a palindrome");
                }else {
                    System.out.println("The inputted string is not a palindrome");
                }
            }else {
                go = true;
                System.out.println("Its over 15 characters!");

            }
        }
    }
}
