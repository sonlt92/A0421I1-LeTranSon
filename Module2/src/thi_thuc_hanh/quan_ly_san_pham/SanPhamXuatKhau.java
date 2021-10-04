package thi_thuc_hanh.quan_ly_san_pham;

import java.io.Serializable;

public class SanPhamXuatKhau extends SanPham implements Serializable {
    private int giaTriXuatKhau;
    private String quocGiaNhapSanPham;

    public SanPhamXuatKhau() {
    }

    public SanPhamXuatKhau(String idSanPham, int maSanPham, String tenSanPham, int giaBan, int soLuong, String nhaSanXuat, int giaTriXuatKhau, String quocGiaNhapSanPham) {
        super(idSanPham, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaTriXuatKhau = giaTriXuatKhau;
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    public double getGiaTriXuatKhau() {
        return giaTriXuatKhau;
    }

    public void setGiaTriXuatKhau(int giaTriXuatKhau) {
        this.giaTriXuatKhau = giaTriXuatKhau;
    }

    public String getQuocGiaNhapSanPham() {
        return quocGiaNhapSanPham;
    }

    public void setQuocGiaNhapSanPham(String quocGiaNhapSanPham) {
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    @Override
    public String toString() {
        return "SanPhamXuatKhau{" + super.toString() +
                "giaTriXuatKhau=" + giaTriXuatKhau +
                ", quocGiaNhapSanPham='" + quocGiaNhapSanPham + '\'' +
                '}';
    }
}
