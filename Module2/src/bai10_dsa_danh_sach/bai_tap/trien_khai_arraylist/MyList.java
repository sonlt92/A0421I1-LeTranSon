package bai10_dsa_danh_sach.bai_tap.trien_khai_arraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPCITY = 10;
    Object elements[];

    public MyList(){
        elements = new Object[DEFAULT_CAPCITY];
    }

    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IndexOutOfBoundsException("Capacity: " + capacity);
        }
    }

    private int size(){
        return this.size;
    }

    private void clear(){
       size = 0;
       for (int i=0; i < elements.length; i++){
           elements[i] = null;
       }
    }

    private boolean add(E element){
        elements[size] = element;
        size++;
        return true;
    }

    private void ensureCapacity(int minCapacity){
        if (minCapacity >= 0){
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        }
    }
}
