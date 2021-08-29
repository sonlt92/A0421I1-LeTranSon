package bai6_ke_thua.bai_tap.point;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();

        point2D.setX(0);
        point2D.setY(3);
        System.out.println(point2D.toString());

        point2D.setXY(0, 4);
        System.out.println("Point2D : " + point2D.toString());

        Point3D point3D = new Point3D();

        point3D.setX(point2D.getX());
        point3D.setY(point2D.getY());
        point3D.setZ(3);
        System.out.println("Point3D: " + point3D.toString());

        point3D.setXYZ(0, 2, 5);
        System.out.println("Point3D: " + point3D.toString());


    }
}
