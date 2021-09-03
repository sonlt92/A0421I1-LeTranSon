package bai_tap_them.giai_thuat;


import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lower, upper, i, n, f, count, k;

        System.out.print("Enter the lower limit: ");
        //reads the lower limit from the user
        lower = sc.nextInt();

        System.out.print("Enter the upper limit: ");
        //reads the upper limit from the user
        upper = sc.nextInt();

        System.out.println("\nSphenic numbers between the given range are: ");
        for (i = lower; i <= upper; i++) {
            n = i;
            k = 0;

            //defining an array that stores distinct prime factors
            int[] prime = {0, 0, 0};

            //finds all the prime factors
            for (f = 2; n != 1; f++) {

                //counts the frequency of the prime factors
                count = 0;
                while (n % f == 0) {
                    count++;
                    n = n / f;
                }
                if (count == 1)
                    prime[k++] = f;
                if (k == prime.length)

                    //breaks the execution if there are 3 unique prime factors
                    break;
            }

            //multiplying the prime factors
            n = prime[0] * prime[1] * prime[2];

            //compares the product (n) with the original number (i)
            if (i == n)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}

