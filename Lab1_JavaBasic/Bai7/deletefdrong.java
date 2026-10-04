package Lab1_JavaBasic.Bai7;

import java.io.File;
public class deletefdrong {
    public static void main(String[] args) {
        File folder = new File("D:\\test");
        if (folder.exists()) {
            if (folder.delete()) {
                System.out.println("Xoa folder thanh cong");
            } else {
                System.out.println("Xoa folder that bai");
            }
        } else {
            System.out.println("Folder khong ton tai");
        }
    }
   
}
