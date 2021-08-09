package bai7_abstract_class_and_interface.bai_tap.trien_khai_interface_resizeable;

public class ResizeableTest {

    public static void main(String[] args) {
<<<<<<< HEAD
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].resize(Math.random() * 99 + 1);
            System.out.print("\n" + shapes[i]);
=======
        Shape[] shape = new Shape[5];
        for (int i = 0; i < 5; i++) {
            shape[i] = getRandomShape();
        }
        Shape.printShape(shape);
        for (Shape x: shape){
            x.resize(Math.random()*100);
>>>>>>> 65f202745445f2277b07669ce54ed9c24886861a
        }


    }


}

