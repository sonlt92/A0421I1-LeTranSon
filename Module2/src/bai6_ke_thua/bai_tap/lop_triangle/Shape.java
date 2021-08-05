package bai6_ke_thua.bai_tap.lop_triangle;

public class Shape {
    private String color = "green";

    public Shape(){

    }

    public Shape(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return "Shape {color = " + color + "}";
    }
}
