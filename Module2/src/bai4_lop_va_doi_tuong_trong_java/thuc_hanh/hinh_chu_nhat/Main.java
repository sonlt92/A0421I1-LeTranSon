package bai4_lop_va_doi_tuong_trong_java.thuc_hanh.hinh_chu_nhat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the width: ");
        double width  = input.nextDouble();
        System.out.print("Enter the height: ");
        double height = input.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.print("Your rectangle: " + rectangle.display());
        System.out.print("\nPerimeter of the Rectangle: " + rectangle.getPerimeter());
        System.out.print("\nArea of the Rectangle: " + rectangle.getArea());
    }
}
