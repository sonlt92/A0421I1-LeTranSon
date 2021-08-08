package bai7_abstract_class_and_interface.bai_tap.trien_khai_interface_resizeable;

public class ResizeableTest {
    public static void main(String[] args) {
//        Shape[] shapes = new Shape[5];
        Shape[] shape = new Shape[5];
        for (int i = 0; i < 5; i++) {
            shape[i] = getRandomShape();
        }
        Shape.printShape(shape);
        for (Shape x: shape){
            x.resize(Math.random()*100);
        }
        System.out.println("\n");
        Shape.printShape(shape);
    }

    static Shape getRandomShape() {
        int random = (int) (Math.round(Math.random() * 2));
        switch (random) {
            case 0:
                return new Square(10);
            case 1:
                return new Rectangle(10, 20);
            default:
                return new Circle(10);
        }
    }
}

