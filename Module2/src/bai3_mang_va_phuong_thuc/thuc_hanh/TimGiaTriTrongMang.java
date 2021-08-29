package bai3_mang_va_phuong_thuc.thuc_hanh;

import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        //Khai bao mang
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};

        //Khai báo biến lưu tên tìm kiếm và  gán với giá trị nhập vào
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name's student: ");
        String input_name = scanner.nextLine();

        //Duyet mang
        boolean isExist = false;
        for (int i=0;i<students.length;i++){
            if (students[i].equals(input_name)){
                System.out.println("Position of the students in the list " + input_name + " is: " + (i + 1));
                isExist = true;
                break;
            }
        }
        if (!isExist){
            System.out.println("Not found " + input_name + " in the lish.");
        }
    }
}
