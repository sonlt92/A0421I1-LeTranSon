package bai16_text_file.bai_tap.copy_file_text;

import java.io.*;

public class Main {
    public static void copyFileUsingFileStreams(File source, File dest) throws Exception {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }

    public static void main(String[] args) throws Exception {
        File source = new File("E:\\STUDY\\A0421I1-LeTranSon\\Module2\\src\\bai16_text_file\\bai_tap\\copy_file_text\\source.txt");
        File dest = new File("E:\\STUDY\\A0421I1-LeTranSon\\Module2\\src\\bai16_text_file\\bai_tap\\copy_file_text\\filecopy.txt");
        // copy file using FileStreams
        copyFileUsingFileStreams(source, dest);

    }
}
