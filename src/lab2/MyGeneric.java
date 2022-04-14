package lab2;

public class MyGeneric <E> {
    private E e;

    MyGeneric(){

    }

    MyGeneric(E e){
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
