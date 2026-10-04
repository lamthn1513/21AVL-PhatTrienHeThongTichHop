package Lab1_JavaBasic.Bai9;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ghiData {
    public static void main(String[] args) {
        String fileName = "D:\\test\\data.dat";
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(10);
            dos.writeInt(20);
            dos.writeDouble(8.5);
            dos.writeUTF("Nguyen Van A");
            dos.close();
            fos.close();
            System.out.println("Ghi file thanh cong");
        } catch (IOException e) {
            System.out.println("Co loi khi ghi file");
        }
    }
}
