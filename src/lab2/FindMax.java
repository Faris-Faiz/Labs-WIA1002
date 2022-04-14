package lab2;

public class FindMax {
    public static class Circle<E extends Comparable<E>> implements Comparable<Circle<E>>{
        private E radius;

        Circle(E radius){
            this.radius = radius;
        }

        public E getRadius() {
            return radius;
        }

        public void setRadius(E radius) {
            this.radius = radius;
        }

        @Override
        public int compareTo(Circle<E> o) {
            return radius.compareTo(o.getRadius());
        }

        public String toString(){
            return String.valueOf(radius);
        }
    }
}


class Tester{
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3};
        String [] strings = {"red", "green", "blue"};
        FindMax.Circle[] circles = {new FindMax.Circle(3), new FindMax.Circle(2.9), new FindMax.Circle(5.9)};
        System.out.println("Max for integer array is: " + max(integers));
        System.out.println("Max for integer array is: " + max(strings));
        System.out.println("Max for integer array is: " + max(circles));
    }

    public static <E extends Comparable<E>> E max(E[] list){
        if(list.length < 0){
            return null;
        }
        E max = list[0];
        for(E temp:list){
            if(temp.compareTo(max)>0){
                max = temp;
            }
        }
        return max;
    }
}