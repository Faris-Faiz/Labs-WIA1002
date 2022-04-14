package lab5.slist;

public class TestSList {
    public static void main(String[] args) {
        SList<String> question1 = new SList<>();
        String[] values = {"Linked list", "is", "easy"};

        // Append the following values individually: “Linked list, is, easy.”
        for (String value : values)
            question1.appendEnd(value);
        // Display these values.
        question1.display();

        //  Remove the word “Linked list” and display the removed value.
        System.out.println("\nRemoved value is " + question1.removeInitial());
        question1.display();

        // Check if ‘difficult’ is in the list.
        System.out.println("\nIs the word difficult in the list? " + question1.contains("difficult") + "\n");

        // Clear the list.
        question1.clear();
        question1.display();
    }
}
