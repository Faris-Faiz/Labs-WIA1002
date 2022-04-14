package lab2;

public class Question4 {
    public static void main(String[] args) {
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red", "blue", "orange", "tan"};

        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));
    }

    public static <E extends Comparable<E>> String minmax(E[] objects){
        for(int i = 0; i < objects.length; i++){
            for (int j = i+1; j < objects.length; j++) {
                if(objects[j].compareTo(objects[i]) > 0){
                    E temp = objects[j];
                    objects[j] = objects[i];
                    objects[i] = temp;
                }
            }
        }

        E min = objects[objects.length-1];
        E max = objects[0];
        return "Min = " + min + ", Max = " + max;
    }
}
