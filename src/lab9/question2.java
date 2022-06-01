package lab9;

public class question2 {
    public static void main(String[] args) {
        String s = "abb";
        printPermutn(s, "");
    }

    // Function to print all the permutations of str
    static void printPermutn(String str, String ans) {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String restOfString = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            printPermutn(restOfString, ans + ch);
        }
    }
}
