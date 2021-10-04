package thi_thuc_hanh.quan_ly_san_pham;

import thi_thuc_hanh.quan_ly_san_pham.impl.QuanLySanPhamImpl;

import java.util.Scanner;

public class Menu {
    public static void displayMainMenu() {
        QuanLySanPhamImpl quanLySanPham = new QuanLySanPhamImpl();
        boolean choice = true;
        while (choice) {
            System.out.print("\n=====CHUONG TRINH QUAN LY SAN PHAM===========");
            System.out.print("\n1. Them Moi");
            System.out.print("\n2. Xoa");
            System.out.print("\n3. Xem danh sach cac san pham");
            System.out.print("\n4. Tim kiem");
            System.out.print("\n5. Thoat");
            System.out.print("\n=============================================");
            Scanner input = new Scanner(System.in);
            System.out.print("\nChon chuc nang: ");

            switch (input.nextInt()) {
                case 1: {
                    quanLySanPham.themMoiSanPham();
                    break;
                }
                case 2: {
                    quanLySanPham.xoaSanPham();
                    break;
                }
                case 3: {
                    quanLySanPham.xemDanhSach();
                    break;
                }
                case 4: {
                    quanLySanPham.timKiemSanPham();
                    break;
                }
                case 5:
                    System.exit(5);
                default:
                    System.out.println("No choice!");
            }
        }
    }


}
