package bai7_abstract_class_and_interface.bai_tap.trien_khai_interface_colorable;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();
        for (Shape shape : shapes) {
            System.out.println(shape);

            if (shape instanceof Colorable) {
                Colorable colorable = (Colorable) shape;
                colorable.howToColor();
            }
        }

    }
}