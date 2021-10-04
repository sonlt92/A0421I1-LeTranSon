package thi_thuc_hanh.quan_ly_san_pham;

import java.io.Serializable;

public class SanPhamNhapKhau extends SanPham  implements Serializable {
    private int giaTriNhapKhau;
    private String tinhThanhNhap;
    private int thueNhapKhau;

    public SanPhamNhapKhau() {
    }

    public SanPhamNhapKhau(String idSanPham, int maSanPham, String tenSanPham, int giaBan, int soLuong, String nhaSanXuat, int giaTriNhapKhau, String tinhThanhNhap, int thueNhapKhau) {
        super(idSanPham, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaTriNhapKhau = giaTriNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public double getGiaTriNhapKhau() {
        return giaTriNhapKhau;
    }

    public void setGiaTriNhapKhau(int giaTriNhapKhau) {
        this.giaTriNhapKhau = giaTriNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public double getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(int thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return "SanPhamNhapKhau{" + super.toString() +
                "giaTriNhapKhau=" + giaTriNhapKhau +
                ", tinhThanhNhap='" + tinhThanhNhap + '\'' +
                ", thueNhapKhau=" + thueNhapKhau +
                '}';
    }
}
