package bai6_ke_thua.bai_tap.lop_circle;

public class Circle {
    private float radius = 10;
    private String color = "White";

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double Area(float radius){
        double area = radius * radius * Math.PI;
        return area;
    }

    public String toString() {
        return "A Circle with color of " + getColor() + " and radius " + getRadius();
    }
}
