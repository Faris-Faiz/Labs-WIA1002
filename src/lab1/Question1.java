package lab1;
import java.io.*;
import java.util.Scanner;


public class Question1 {
    static String file_directory = "C:\\Users\\mfari\\OneDrive - Universiti Malaya\\Degree\\Semester 2\\WIA1002 - Data Structure\\Lab\\Lab 1\\MuhammadFarisbinAhmadFaiz_U2000421.txt";

    public static void main(String[] args) {
        Scanner x;
        Scanner y = new Scanner(System.in);

        System.out.print("Input the date: ");
        writeToFile(y.nextLine());
        writeToFile("\n\n");
        System.out.println("What are you feeling about this subject? ");
        writeToFile(y.nextLine());

        try{
            x = new Scanner(new File(file_directory));
            x.useDelimiter("[ ]");
            while(x.hasNext()){
                String current_word = x.next();
                System.out.print(current_word + " ");
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    public static void writeToFile(String str){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file_directory, true));
            bw.write(str);
            bw.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
