package Lab1_JavaBasic.Bai9;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class docData {
    public static void main(String[] args) {
        String fileName = "D:\\test\\data.dat";
        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            int a = dis.readInt();
            int b = dis.readInt();
            double diem = dis.readDouble();
            String ten = dis.readUTF();
            System.out.println("So thu nhat: " + a);
            System.out.println("So thu hai: " + b);
            System.out.println("Diem: " + diem);
            System.out.println("Ho ten: " + ten);
            dis.close();
             fis.close();
        } catch (IOException e) {
            System.out.println("Co loi khi doc file");
        }
    }
}
