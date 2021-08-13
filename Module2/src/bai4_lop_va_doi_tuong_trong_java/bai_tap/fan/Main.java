package bai4_lop_va_doi_tuong_trong_java.bai_tap.fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.fast);
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.setOn(false);
        System.out.print(fan1);

        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.medium);
        fan2.setRadius(5);
        fan2.setColor("Blue");
        fan2.setOn(true);
        System.out.print(fan2);
    }
}
