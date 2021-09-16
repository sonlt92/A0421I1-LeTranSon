package bai17_binary_file_va_serialization.bai_tap.quan_ly_san_pham;

public class Main {
    public static void main(String[] args) throws Exception {
        ProcessProduct ps = new ProcessProduct();   // Tao doi tuong cua lop ProcessProduct
        Product[] product1 = null;
        product1 = ps.create();  // Nhap product
        ps.write(product1);     // Viet vao file
        Product[] product2 = null;
        product2 = ps.read();   // Doc tu file
        ps.show(product2);      //Hien thi kq
    }
}
