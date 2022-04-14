package lab2;

public class Question2 {
    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric<>("Haha");
        MyGeneric<Integer> intObj = new MyGeneric<>(69);

        System.out.println(strObj.getE());
        System.out.println(intObj.getE());
    }
}
