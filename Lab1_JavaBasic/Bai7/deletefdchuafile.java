package Lab1_JavaBasic.Bai7;

import java.io.File;
public class deletefdchuafile {
    public static void main(String[] args) {
        File folder = new File("D:\\test");
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {

                    if (file.isFile()) {
                        file.delete();
                    }
                }
            }
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
