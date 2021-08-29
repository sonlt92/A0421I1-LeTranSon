package bai4_lop_va_doi_tuong_trong_java.bai_tap.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a: ");
        double a = input.nextDouble();
        System.out.print("Input b: ");
        double b = input.nextDouble();
        System.out.print("Input c: ");
        double c = input.nextDouble();

        double delta;
        double x1;
        double x2;
        double x;
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        delta = quadraticEquation.delta(a,b,c);
        if (delta  > 0) {
            x1 = quadraticEquation.getRoot1(a,b,delta);
            x2 = quadraticEquation.getRoot2(a,b,delta);
            System.out.print("The equation has to root " + x1 + " and " + x2);
        } else if (delta == 0){
            x = quadraticEquation.getOneRoot(a,b);
            System.out.print("The equation has one root: " + x);
        } else {
            System.out.print("The equation has real roots.");
        }

    }
}
