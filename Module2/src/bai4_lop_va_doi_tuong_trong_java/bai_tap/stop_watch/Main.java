package bai4_lop_va_doi_tuong_trong_java.bai_tap.stop_watch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] number = new int[100000];
        for (int i=0;i< number.length;i++){
            number[i] = (int) (Math.random()*100000);
        }
        StopWatch stopWatch = new StopWatch();
        Arrays.sort(number);
        stopWatch.stop();
        System.out.print("Milisecond: " + stopWatch.getElapsedTime());
        stopWatch.start();
        System.out.print("\nMilisecond: " + stopWatch.getElapsedTime());
    }
}
