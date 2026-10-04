package Lab1_JavaBasic.Bai8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class copyFile {
    public static void main(String[] args) {
        String fileNguon = "D:\\test\\abc.txt";
        String fileDich = "D:\\test\\copy_abc.txt";
        try {
            FileInputStream fis = new FileInputStream(fileNguon);
            FileOutputStream fos = new FileOutputStream(fileDich);
            byte[] arr = new byte[1024];
            int n;
            while ((n = fis.read(arr)) != -1) {
                fos.write(arr, 0, n);
            }
            fis.close();
            fos.close();
            System.out.println("Copy file thanh cong");
        } catch (IOException e) {
            System.out.println("Co loi khi copy file");
        }
    }
}
