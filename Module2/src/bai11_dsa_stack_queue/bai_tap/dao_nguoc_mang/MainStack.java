package bai11_dsa_stack_queue.bai_tap.dao_nguoc_mang;

import java.util.Stack;

public class MainStack {
    public static void main(String[] args) {
        Stack<Integer> listNumber = new Stack<>();
        listNumber.push(1);
        listNumber.push(2);
        listNumber.push(3);
        listNumber.push(4);
        listNumber.push(5);
        listNumber.push(6);
        listNumber.push(7);
        listNumber.push(8);
        listNumber.push(9);
        listNumber.push(10);

        System.out.println("Mang ban dau: ");
        for (Integer mang : listNumber){
            System.out.print("[" + mang + "]");
        }

        System.out.println("\nMang da dao nguoc: ");
        while (!listNumber.isEmpty()) {
            System.out.print("[" + listNumber.pop() + "]");
        }



        Stack<String> listString = new Stack<>();
        listString.push("L");
        listString.push("E");
        listString.push("T");
        listString.push("R");
        listString.push("A");
        listString.push("N");
        listString.push("S");
        listString.push("O");
        listString.push("N");

        System.out.println("\nChuoi ban dau: ");
        for (String mangChu : listString){
            System.out.print("" + mangChu + "");
        }

        System.out.println("\nChuoi da dao nguoc: ");
        while (!listString.isEmpty()) {
            System.out.print("" + listString.pop() + "");
        }
    }

}
