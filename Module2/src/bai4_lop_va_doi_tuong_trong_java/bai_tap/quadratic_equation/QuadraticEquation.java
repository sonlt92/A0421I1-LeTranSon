package bai4_lop_va_doi_tuong_trong_java.bai_tap.quadratic_equation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;


    public QuadraticEquation() {

    }


    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double delta (double a, double b, double c){
        return b * b - 4 * a * c;
    }

    public double getRoot1(double a, double b, double delta) {
        return (-b + Math.sqrt(delta)) / (2 * a);
    }

    public double getRoot2(double a, double b, double delta) {
        return (-b - Math.sqrt(delta)) / (2 * a);
    }

    public double getOneRoot(double a, double b){
        return -b / (2 * a);
    }
}
