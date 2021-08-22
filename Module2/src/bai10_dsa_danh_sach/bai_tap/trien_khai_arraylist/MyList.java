package bai10_dsa_danh_sach.bai_tap.trien_khai_arraylist;

import java.util.Arrays;
import java.util.Objects;

public class MyList<E> {
    //So luong phan tu
    private int size = 0;
    //Suc chua cua mang
    private static final int DEFAULT_CAPACITY = 10;
    //Mang chua phan tu
    private Object elements[];

    //Suc chua mac dinh khi khoi tao bang contructor
    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity: " + capacity);
        }
    }



}
