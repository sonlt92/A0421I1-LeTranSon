package bai11_dsa_stack_queue.bai_tap.dao_nguoc_mang;

import java.util.Stack;

public class ArrayStack {
    public static void main(String[] args) {
        int[] arrayNew = arrayInteger();
        reverseArray(arrayNew);
        for (int i : arrayNew) {
            System.out.println(i);
        }
    }
    public static int[] arrayInteger() {
        int[] arrayNumber = {1,2,3,4,5,6,7,8,9,10};
        return arrayNumber;
    }

    public static void reverseArray(int[] arrayInteger) {
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < arrayInteger.length; i++) {
            integerStack.push(arrayInteger[i]);
        }

        for (int i = 0; i < arrayInteger.length; i++) {
            arrayInteger[i] = integerStack.pop();
        }
    }
}
