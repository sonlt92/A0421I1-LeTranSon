package bai7_abstract_class_and_interface.bai_tap.trien_khai_interface_resizeable;

public class ResizeableTest {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].resize(Math.random() * 99 + 1);
            System.out.print("\n" + shapes[i]);
        }


    }


}

