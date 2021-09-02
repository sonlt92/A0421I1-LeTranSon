package bai12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist;

import java.util.Comparator;

public class CompareTest implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getId() == o2.getId()) {
            return 0;
        } else if (o1.getId() > o2.getId()) {
            return 1;
        } else {
            return -1;
        }
    }

}
