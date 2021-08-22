package bai10_dsa_danh_sach.bai_tap.trien_khai_arraylist;

import java.util.Arrays;

public class MyList<E> {
    //Suc chua cua mang
    private static final int DEFAULT_CAPACITY = 10;
    //So luong phan tu
    private int size = 0;
    //Mang chua phan tu
    public Object elements[];

    //Suc chua mac dinh khi khoi tao bang contructor
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity: " + capacity);
        }
    }

    public int size() {
        return this.size;
    }

    //Phuong thuc clear
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }


    //Phuong thuc add
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--){
                elements[i] = elements[i-1];
            }
            elements[index] = element;
            size++;
        }
    }

    //Phuong thuc tang kich thuoc
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }


}
