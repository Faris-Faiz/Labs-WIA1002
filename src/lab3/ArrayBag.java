package lab3;

import java.sql.Array;

public class ArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private Integer DEFAULT_CAPACITY = 25;
    private Integer numberOfEntries = 0;
    private static Integer MAX_CAPACITY = 1000;

    public ArrayBag(int desiredCapacity){
        if(desiredCapacity <= MAX_CAPACITY){
            T[] tempBag = (T[]) new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
        }
    }

    public ArrayBag(){
        bag = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        if(bag.length < MAX_CAPACITY){
            return false;
        } else{
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        if(bag.length == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean add(T newEntry) {
        if(!isFull()){
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public T remove() {
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    @Override
    public void clear() {
        while(!isEmpty()){
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int freq = 0;
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                freq++;
            }
        }
        return freq;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                found = true;
            }
        }
        return found;
    }

    @Override
    public T[] toArray() {
        T[] result = (T[])new Object[numberOfEntries];

        for (int index = 0; index < numberOfEntries; index++)
        {
            result[index] = bag[index];
        }
        return result;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag) {
        int sizeOfUnionBag = getCurrentSize() + anotherBag.getCurrentSize();
        if (sizeOfUnionBag > DEFAULT_CAPACITY) {
            System.out.println("The number of elements in the bag is more than 25");
            System.out.println("Union bag is not created");
            return null;
        }

        BagInterface<T> unionBag = new ArrayBag<>();
        for (int i = 0; i < getCurrentSize(); i++) {
            unionBag.add(bag[i]);
        }
        ArrayBag<T> copyOfAnotherBag = (ArrayBag<T>) anotherBag;
        for (int i = 0; i < copyOfAnotherBag.getCurrentSize() ; i++) {
            unionBag.add(copyOfAnotherBag.bag[i]);
        }
        return unionBag;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> anotherBag){
        BagInterface<T> intersectionBag = new ArrayBag<>();
        ArrayBag<T> copyOfAnotherBag = new ArrayBag<>();
        ArrayBag<T> copyOfAnotherBag2 = (ArrayBag<T>) anotherBag;

        for (int i = 0; i < copyOfAnotherBag2.getCurrentSize(); i++) {
            copyOfAnotherBag.add(copyOfAnotherBag2.bag[i]);
        }

        for (int i = 0; i < copyOfAnotherBag.getCurrentSize(); i++) {
            if (copyOfAnotherBag.contains(bag[i])) {
                intersectionBag.add(bag[i]);
                copyOfAnotherBag.remove(bag[i]);
            }
        }
        return intersectionBag;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag){
        BagInterface<T> differenceBag = new ArrayBag<>();
        ArrayBag<T> copyOfAnotherBag = (ArrayBag<T>) anotherBag;

        for(int i = 0; i < getCurrentSize(); i++){
            differenceBag.add(bag[i]);
        }

        for(int i = 0; i < copyOfAnotherBag.getCurrentSize(); i++){
            if(differenceBag.contains(copyOfAnotherBag.bag[i])){
                differenceBag.remove(copyOfAnotherBag.bag[i]);
            }
        }
        return differenceBag;
    }

    private T removeEntry(int givenIndex){
        T result = null;

        if (!isEmpty() && (givenIndex >= 0)) {
            result = bag[givenIndex];
            int lastIndex = numberOfEntries - 1;
            bag[givenIndex] = bag[lastIndex];
            bag[lastIndex] = null;
            numberOfEntries--;
        }

        return result;
    }

    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean found = false;
        int index = 0;

        while (!found && (index < numberOfEntries))
        {
            if (anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            }
            index++;
        }

        return where;
    }
}
