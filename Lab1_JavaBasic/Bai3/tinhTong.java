package Lab1_JavaBasic.Bai3;
import java.util.Scanner;

public class tinhTong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so thu nhat: ");
        int a = sc.nextInt();
        System.out.print("Nhap so thu hai: ");
        int b = sc.nextInt();
        int tong = a + b;
        System.out.println("Tong = " + tong);
    }
}