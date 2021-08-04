package bai6_ke_thua.bai_tap.point;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        point2D.setXY(10f,20f);
        point2D.toString();
        System.out.println(point2D.toString());

        Point3D point3D = new Point3D();
        point3D.setXYZ(10f,20f,30f);
        System.out.println(point3D.toString());


    }
}
