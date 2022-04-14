package lab2;

public class StorePair<T> implements Comparable<T>{
    private T first, second;

    public StorePair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }else{return false;}
    }

    @Override
    public int compareTo(T o) {
        if(this == o){
            return 1;
        }else {return 0;}
    }

    @Override
    public String toString() {
        return "first = " + first + " second = " + second;
    }
}
