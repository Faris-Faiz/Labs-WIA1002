package lab1;

import java.io.*;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {

        int text1 = 0;
        try{
            Scanner x = new Scanner(new File("src/text1.txt"));
            while(x.hasNext()){
                String[] characters = x.nextLine().split(",");
                for (String character : characters) {
                    System.out.print(character);
                    text1++;
                }
                System.out.println();
            }
            x.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
        System.out.println("The number of characters is: " + text1 + "\n");

        int text2 = 0;
        try{
            Scanner x = new Scanner(new File("src/text2.txt"));
            while(x.hasNext()){
                String[] characters = x.nextLine().split(", ");
                for (String character : characters) {
                    System.out.print(character);
                    text2++;
                }
                System.out.println();
            }
            x.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
        System.out.println("The number of characters is: " + text2 + "\n");

        int text3 = 0;
        try{
            Scanner x = new Scanner(new File("src/text3.txt"));
            while(x.hasNext()){
                String[] characters = x.nextLine().split("; ");
                for (String character : characters) {
                    System.out.print(character);
                    text3++;
                }
                System.out.println();
            }
            x.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
        System.out.println("The number of characters is: " + text3 + "\n");

        int text4 = 0;
        try{
            Scanner x = new Scanner(new File("src/text4.txt"));
            while(x.hasNext()){
                String characters = x.nextLine();
                for(int i = 0; i < characters.length(); i++){
                    if(characters.charAt(i) >= 'A' && characters.charAt(i) <= 'z'){
                        text4++;
                        System.out.print(characters.charAt(i));
                    }
                }
            }
            System.out.println();
            x.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
        System.out.println("The number of characters is: " + text4 + "\n");
    }
}