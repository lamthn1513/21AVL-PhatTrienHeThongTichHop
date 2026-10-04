package Lab1_JavaBasic.Bai7;

import java.io.File;
public class delete {
    public static void main(String[] args) {
        File file = new File("D:\\test\\abc.txt");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Xoa file thanh cong");
            } else {
                System.out.println("Xoa file that bai");
            }
        } else {
            System.out.println("File khong ton tai");
        }
    }
}
