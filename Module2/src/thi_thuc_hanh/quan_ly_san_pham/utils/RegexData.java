package thi_thuc_hanh.quan_ly_san_pham.utils;

import java.util.Scanner;

public class RegexData {
    static Scanner scanner = new Scanner(System.in);

    public static String regex(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex)) {
                check = false;
            }else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        }while (check);
        return temp;
    }
}
