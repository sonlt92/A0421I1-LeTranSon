package thi_thuc_hanh.quan_ly_san_pham.impl;


import thi_thuc_hanh.quan_ly_san_pham.*;
import thi_thuc_hanh.quan_ly_san_pham.utils.RegexData;
import thi_thuc_hanh.quan_ly_san_pham.utils.WriteAndReadFileCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySanPhamImpl implements QuanLySanPham {
    private static final String REGEX_STR = "[A-Z][a-z]+";
    private static final String REGEX_MASANPHAM = "(SP)[\\d]{5}";
    private static final String REGEX_GIA = "[\\d]";
    private static final String REGEX_SOLUONG = "^[1-9]|([1][0-9])$";
    private static final String REGEX_NHASANXUAT = "[A-Z][a-z]+";
    private static final String REGEX_GIAXUATKHAU = "[\\d]";
    private static final String REGEX_QUOCGIA = "[A-Z][a-z]+";
    private static List<SanPhamNhapKhau> danhSachSanPham = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);



    @Override
    public void themMoiSanPham() {
        System.out.println("Nhap id san pham: ");
        String id = input.nextLine();
        System.out.println("Nhap ma san pham: ");
        int maSanPham = Integer.parseInt(input.nextLine());
        System.out.println("Nhap ten san pham: ");
        String ten = input.nextLine();
        System.out.println("Nhap gia: ");
        int gia = Integer.parseInt(input.nextLine());
        System.out.println("Nhap so luong: ");
        int soLuong = Integer.parseInt(input.nextLine());
        System.out.println("Nhap nha san xuat: ");
        String nsx = input.nextLine();
        System.out.println("Nhap gia nhap khau: ");
        int giaNhapKhau = Integer.parseInt(input.nextLine());
        System.out.println("Nhap tinh thanh nhap khau: ");
        String tinhThanh = input.nextLine();
        System.out.println("Nhap thue nhap khau: ");
        int thue = Integer.parseInt(input.nextLine());
        SanPhamNhapKhau sanPhamNhapKhaunhapKhau = new SanPhamNhapKhau(id, maSanPham, ten, gia, soLuong, nsx, giaNhapKhau, tinhThanh, thue);
        danhSachSanPham.add(sanPhamNhapKhaunhapKhau);
        WriteAndReadFileCSV.writeFile(danhSachSanPham,"src/thi_thuc_hanh/quan_ly_san_pham/data/products.csv" );
    }




    @Override
    public void xemDanhSach() {
        WriteAndReadFileCSV.readFile("src/thi_thuc_hanh/quan_ly_san_pham/data/products.csv");
        for (SanPhamNhapKhau xuatKhau : danhSachSanPham) {
            System.out.println(xuatKhau.toString());
        }
    }

    private boolean getId(String id) {
        for (SanPhamNhapKhau nhapKhau : danhSachSanPham) {
            if (nhapKhau.getIdSanPham().equals(id)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void xoaSanPham() {
        System.out.println("Nhap ID can xoa: ");
        String id = "";
        try {
            id = input.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean getId = getId(id);
        for (int i = 0; i < danhSachSanPham.size(); i++) {
            if (getId) {
                SanPhamXuatKhau xuatKhau = new SanPhamXuatKhau();
                danhSachSanPham.remove(xuatKhau);
            }
        }

    }

    @Override
    public void timKiemSanPham() {

    }
}
