package bai7_abstract_class_and_interface.bai_tap.trien_khai_interface_resizeable;

public class Square extends Rectangle implements Resizeable{
    private String color = "black";
    private boolean filled = false;

    public Square(){

    }

    public Square(double i) {

    }

    public void setShape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }

    public static void printShape(Shape[] shape) {
        for (Shape x : shape) {
            System.out.println(x.toString());
        }
    }
}
