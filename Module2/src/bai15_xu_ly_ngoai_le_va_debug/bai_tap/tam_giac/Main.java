package bai15_xu_ly_ngoai_le_va_debug.bai_tap.tam_giac;

public class Main {
    public static void main(String[] args) {
        Triangle triangle;
        try {
            triangle = new Triangle(10, 10, 100);
        } catch (Triangle.IllegalTriangleException e) {
            e.printStackTrace();
        }
    }
}
