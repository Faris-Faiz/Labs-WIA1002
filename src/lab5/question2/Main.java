package lab5.question2;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static LinkedList<String> studentNames = new LinkedList<>();

    public static void step1(){
        boolean continueOrNot = true;
        String studentName = "";
        System.out.println("Enter your student name list. Enter 'n' to end...");

        while(continueOrNot){
            studentName = in.nextLine();

            if(studentName.equals("n")){
                System.out.println("\nYou have entered the following students' name:");
                studentNames.printList();

                System.out.println("\nThe number of students entered is : " + studentNames.getSize());
                continueOrNot = false;
            }else {
                studentNames.add(studentName);
            }
        }
    }

    public static void step2(){
        boolean continueOrNot = true;

        while (continueOrNot){
            System.out.println("\nAll the names entered are correct? Enter 'r' to rename the student's name, 'n' to proceed.");
            String answer = in.nextLine();

            if(answer.equals("r")) {
                System.out.println("\nEnter the existing student name that you want to rename : ");
                String wrongStudentName = in.nextLine();

                if (studentNames.contains(wrongStudentName)) {
                    System.out.println("\nEnter the new name : ");
                    String correctStudentName = in.nextLine();

                    studentNames.replace(wrongStudentName, correctStudentName);

                    System.out.println("\nThe new student list is : ");
                    studentNames.printList();
                } else {
                    System.out.println("That student doesn't exist!");
                }
            } else {
                continueOrNot = false;
            }
        }
    }

    public static void step3(){
        boolean continueOrNot = true;

        while (continueOrNot){
            System.out.println("\nDo you want to remove any of your student name? Enter 'y' for yes, 'n' to proceed.");
            String answer = in.nextLine();

            if(answer.equals("y")){
                System.out.println("\nEnter a student name to remove : ");
                String studentToBeRemoved = in.nextLine();

                if(studentNames.contains(studentToBeRemoved)){
                    studentNames.removeElement(studentToBeRemoved);
                    System.out.println("\nThe number of updated students is : " + studentNames.getSize());
                    System.out.println("The updated students list is : ");
                    studentNames.printList();
                }else {
                    System.out.println("That student doesn't exist!");
                }
            }else {
                continueOrNot = false;
            }
        }
        System.out.println("\nAll student data captured complete. Thank you!");
    }

    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }
}
