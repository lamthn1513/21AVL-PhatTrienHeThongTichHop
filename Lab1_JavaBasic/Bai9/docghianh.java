package Lab1_JavaBasic.Bai9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class docghianh {
     public static void main(String[] args) {
        String fileNguon = "D:\\test\\anh.jpg";
        String fileDich = "D:\\test\\anh_copy.jpg";
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
            System.out.println("Copy anh thanh cong");
        } catch (IOException e) {
            System.out.println("Co loi khi doc/ghi anh");
        }
    }
}

