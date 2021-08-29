package bai4_lop_va_doi_tuong_trong_java.bai_tap.fan;

public class Fan {
    final int slow = 1;
    final int medium = 2;
    final int fast = 3;

    private int speed = slow;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan(){
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.on = false;
    }

    public String toString(){
        if (!isOn()){
            return "\nSpeed: " + speed + " Radius: " + radius + " Color " + color + " fan is on";
        } else {
            return "\nSpeed: " + speed + " Radius: " + radius + " Color " + color + " fan is off";
        }
    }
}
