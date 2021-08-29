package bai7_abstract_class_and_interface.thuc_hanh.trien_khai_interface_so_sanh;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
