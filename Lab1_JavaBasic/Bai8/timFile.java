package Lab1_JavaBasic.Bai8;

import java.io.File;
public class timFile {
    public static void timFile(File folder, String tenFile) {
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().equals(tenFile)) {
                            System.out.println("Tim thay file: " + file.getAbsolutePath());
                        }
                    } else if (file.isDirectory()) {
                        timFile(file, tenFile);
                    }
                }
            }
        }
    }
}
