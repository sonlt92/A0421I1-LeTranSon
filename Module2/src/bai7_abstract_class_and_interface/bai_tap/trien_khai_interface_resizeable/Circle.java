package bai7_abstract_class_and_interface.bai_tap.trien_khai_interface_resizeable;

public class Circle extends Shape implements Resizeable{
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        setShape(color, filled);
        this.radius = radius;
    }

    private void setShape(String color, boolean filled) {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }


    @Override
    public void resize(double percent) {
        this.setRadius(this.getRadius() + this.getRadius() * percent/100);
    }
}
