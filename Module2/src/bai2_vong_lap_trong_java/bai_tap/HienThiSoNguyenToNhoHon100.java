package bai2_vong_lap_trong_java.bai_tap;

public class HienThiSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        System.out.println("Is a prime number less than 100 is: ");
        for (int i = 0; i < 100; i++) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
