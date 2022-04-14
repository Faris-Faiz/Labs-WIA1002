import java.util.ArrayList;
import java.util.Collections;

public class CompareMax {
    public static <E extends Comparable<E>> E maximum(E o1, E o2, E o3) {
        ArrayList<E> temp = new ArrayList<>();
        temp.add(o1);temp.add(o2);temp.add(o3);
        return Collections.max(temp);
    }

    public static void main(String[] args) {
        Integer int1 = 2;
        Integer int2 = 3;
        Integer int3 = 4;
        System.out.println(maximum(int1, int2, int3));
    }
}
