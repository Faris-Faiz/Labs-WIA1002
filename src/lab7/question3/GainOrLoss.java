package lab7.question3;
import lab7.question1.MyQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GainOrLoss{
    public static void main(String[] args) {
        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> t = new LinkedList<>();
        MyQueue<Integer> share = new MyQueue<>();
        MyQueue<Integer> price = new MyQueue<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
        String inputString = input.nextLine();
        int gain = 0;

        while(!inputString.equals("")){

            String[] split = inputString.split(" ");
            int x = Integer.parseInt(split[1]);
            int y = Integer.parseInt(split[4].substring(1));

            if(inputString.charAt(0) == 'B'){
                System.out.println("Buying now...");
                share.enqueue(x);
                price.enqueue(y);
            }else{
                System.out.println("Selling the shares now...");

                while(x > 0 && !share.isEmpty()){
                    int shareDequeue = share.peek();
                    int priceDequeue = price.peek();

                    if(shareDequeue == x){
                        shareDequeue = share.dequeue();
                        priceDequeue = price.dequeue();
                        gain += (x * (y - priceDequeue));
                        x = 0;
                    } else if (shareDequeue > x){
                        gain += (x * (y - priceDequeue));
                        share.set(share.peek() - x);
                        x = 0;
                    } else{
                        shareDequeue = share.dequeue();
                        priceDequeue = price.dequeue();
                        gain += (shareDequeue * (y - priceDequeue));
                        x -= shareDequeue;
                    }

                    System.out.println("Total capital (Gain/Loss): " + gain);
                }
            }

            if(share.isEmpty()){
                System.out.println("No shares to sell!");
            }

            System.out.println("Queue for Share: " + share);
            System.out.println("Queue for Price: " + price);

            System.out.println("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
            inputString = input.nextLine();

        }

        System.out.println("Final Capital (Gain / Loss): " + gain);
    }
}