package bai6_ke_thua.bai_tap.lop_point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point();

        point.setX(10);
        point.setY(20);
        System.out.println("Point : " + point.toString());

        point.setXY(30, 40);
        System.out.println("Point : " + point.toString());

        MovablePoint movablePoint = new MovablePoint();

        movablePoint.setX(point.getX());
        movablePoint.setY(point.getY());

        movablePoint.setxSpeed(50);
        movablePoint.setySpeed(60);

        movablePoint.move();
        //Vi du: x= 50+30; y = 40+60;
        System.out.println(movablePoint.toString());
    }
}
