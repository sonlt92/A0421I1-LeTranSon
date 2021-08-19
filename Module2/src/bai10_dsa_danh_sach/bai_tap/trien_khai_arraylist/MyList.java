package bai10_dsa_danh_sach.bai_tap.trien_khai_arraylist;

public class MyList {
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


}
