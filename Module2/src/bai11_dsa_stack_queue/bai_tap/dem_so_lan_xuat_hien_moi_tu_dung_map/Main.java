package bai11_dsa_stack_queue.bai_tap.dem_so_lan_xuat_hien_moi_tu_dung_map;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        System.out.println("Nhap vao 1 chuoi bat ky: ");
        Scanner scanner = new Scanner(System.in);
        String chuoi = scanner.nextLine();

        String[] listTu = chuoi.split(" ");
        for (String element : listTu) {
            if (map.containsKey(element.toUpperCase())) {
                map.put(element.toUpperCase(), map.get(element.toUpperCase()) + 1);
            } else {
                map.put(element.toUpperCase(), 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s xuat hien %d lan\n", entry.getKey(), entry.getValue().intValue());
        }
    }
}
