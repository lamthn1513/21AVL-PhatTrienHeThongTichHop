package Lab1_JavaBasic.Bai7;

import java.io.File;

public class deleteall {
    public static void xoaFolder(File folder) {
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {

                    if (file.isFile()) {
                        file.delete();
                    } else if (file.isDirectory()) {
                        xoaFolder(file);
                    }
                }
            }

            folder.delete();
        }
    }
    public static void main(String[] args) {
        File folder = new File("D:\\test");
        if (folder.exists()) {
            xoaFolder(folder);
            System.out.println("Xoa folder thanh cong");
        } else {
            System.out.println("Folder khong ton tai");
        }
    }
}
