package lab2;

public class Question1 {
    public static void main(String[] args) {
        StorePairGeneric<Integer> a = new StorePairGeneric<>(6, 4);
        StorePairGeneric<Integer> b = new StorePairGeneric<>(2, 2);
        StorePairGeneric<Integer> c = new StorePairGeneric<>(6, 3);

        System.out.println("a compareTo b: " + a.getFirst().compareTo(b.getFirst()));
        System.out.println("a equals b: " + a.getFirst().equals(b.getFirst()));
        System.out.println();

        System.out.println("b compareTo c: " + b.getFirst().compareTo(c.getFirst()));
        System.out.println("b equals c: " + b.getFirst().equals(c.getFirst()));
        System.out.println();

        System.out.println("c compareTo a: " + c.getFirst().compareTo(a.getFirst()));
        System.out.println("c equals a: " + c.getFirst().equals(a.getFirst()));
        System.out.println();
    }
}
