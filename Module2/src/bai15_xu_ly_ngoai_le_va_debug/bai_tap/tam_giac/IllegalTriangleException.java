package bai15_xu_ly_ngoai_le_va_debug.bai_tap.tam_giac;

public class IllegalTriangleException extends IllegalArgumentException{
    private double s1;
    private double s2;
    private double s3;

    public IllegalTriangleException(double s1, double s2, double s3) {
        super("Not a real triangle:" + " side1 = " + s1 + " side2 = " + s2 + " side3 = " + s3);
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public double getS1() {
        return s1;
    }

    public double getS2() {
        return s2;
    }

    public double getS3() {
        return s3;
    }

}
