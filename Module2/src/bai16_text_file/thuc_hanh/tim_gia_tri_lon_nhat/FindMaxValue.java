package bai16_text_file.thuc_hanh.tim_gia_tri_lon_nhat;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("E:\\STUDY\\A0421I1-LeTranSon\\Module2\\src\\bai16_text_file\\thuc_hanh\\tim_gia_tri_lon_nhat\\number.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("E:\\STUDY\\A0421I1-LeTranSon\\Module2\\src\\bai16_text_file\\thuc_hanh\\tim_gia_tri_lon_nhat\\result.txt", maxValue);
    }
}
