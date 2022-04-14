package lab2;

public class MinMaxTwoDArray {

    public MinMaxTwoDArray() {

    }

    public static <E extends Comparable<E>> E min(E[][] list){
        if(list.length < 0){
            return null;
        }
        E min = list[0][0];
        for (E[] temp1 : list) {
            for (E temp2 : temp1) {
                if (temp2.compareTo(min) < 0) {
                    min = temp2;
                }
            }
        }
        return min;
    }

    public static <E extends Comparable<E>> E max(E[][] list){
        if(list.length < 0){
            return null;
        }
        E max = list[0][0];
        for (E[] temp1 : list) {
            for (E temp2 : temp1) {
                if (temp2.compareTo(max) > 0) {
                    max = temp2;
                }
            }
        }
        return max;
    }
}


class Test{
    public static void main(String[] args) {
        Integer [][] integers = {{4, 5, 6}, {1, 2, 3}};
        System.out.println("Max: " + MinMaxTwoDArray.max(integers));
        System.out.println("Min: " + MinMaxTwoDArray.min(integers));
    }
}
