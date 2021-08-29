package bai6_ke_thua.bai_tap.lop_circle;

public class Cylinder extends Circle{
    float height = 5;

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public double Volume(float height, float radius){
        double vol = radius * radius * height * Math.PI;
        return vol;
    }

    public String toString(){
        return "\nA Cylinder with height of " + getHeight() + " and volume " + Volume(5,10) + " extends " + super.toString();
    }
}
