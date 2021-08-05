package bai6_ke_thua.bai_tap.lop_triangle;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public Triangle(){

    }

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getPerimeter(){
        return (side1 + side2 + side3)/2;
    }

    public double getArea(){
        double perimeter = (getPerimeter() - side1) * (getPerimeter() - side2) * (getPerimeter() - side3);
        return Math.sqrt(perimeter * getPerimeter());
    }

    public String toString(){
        return  "Triangle {side 1= " + side1 + ", side 2= " + side2 + ", side 3= " + side3 + "} color = " + getColor();
    }
}
