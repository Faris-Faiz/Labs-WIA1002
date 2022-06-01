package lab9;

public class question1 {
    // Create a recursive function that accepts a String parameter, and substitute any of the
    // lowercase “a” (no applicable for uppercase "A") found with “i” char.

    public static void main(String[] args) {
        System.out.println("flabbergasted");
        System.out.println(replace("flabbergasted", 0));
    }

    public static String replace(String s, int index){
        if(index == s.length()) {
            return s;
        }
        if(s.charAt(index) == 'a'){
            s = s.substring(0, index) + 'i' + s.substring(index + 1);
        }
        return replace(s, index + 1);
    }
}
