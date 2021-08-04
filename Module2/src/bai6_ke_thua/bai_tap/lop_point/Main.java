package bai6_ke_thua.bai_tap.lop_point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        point.setXY(10,20);
        System.out.println(point.toString());

        MovablePoint movablePoint = new MovablePoint();
        movablePoint.setSpeed(30,40);
        System.out.println(movablePoint.toString());
    }
}
