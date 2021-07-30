package bai5_access_modifier_static_method_static_property.baitap.access_modifier;

import java.util.Scanner;

public class Circle {
    private double radius = 1.0;
    String color = "red";

    public Circle(){

    }

    public Circle(double radius){

    }

    public double getRadius(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input radius: ");
        radius = input.nextDouble();
        radius *= radius ;
        System.out.print("Radius: " + radius);
        return radius;
    }

    public double getArea(){
        double area = radius * Math.PI;
        System.out.print("\nArea: " + area);
        return area;
    }
}
