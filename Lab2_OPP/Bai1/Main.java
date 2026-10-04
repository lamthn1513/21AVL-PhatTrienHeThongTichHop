package Lab2_OPP.Bai1;

public class Main {

    public static void main(String[] args) {

        SanPham sp1 = new SanPham(
                "SP01",
                "Laptop",
                15000000,
                10
        );
        SanPham sp2 = new SanPham(
                "SP02",
                "Chuot",
                500000,
                20
        );

        System.out.println("===== THONG TIN BAN DAU =====");
        System.out.println("\n--- San pham 1 ---");
        sp1.hienThiThongTin();
        System.out.println("\n--- San pham 2 ---");
        sp2.hienThiThongTin();

        //Nhap them hang
        System.out.println("\n===== NHAP THEM HANG =====");
        System.out.println("\nTruoc khi nhap:");
        sp1.hienThiThongTin();
        sp1.nhapHang(5);
        System.out.println("\nSau khi nhap 5 san pham:");
        sp1.hienThiThongTin();

        // Ban hang thanh cong
        System.out.println("\n===== BAN HANG THANH CONG =====");
        System.out.println("\nTruoc khi ban:");
        sp1.hienThiThongTin();
        boolean ketQua1 = sp1.banHang(3);
        System.out.println("\nKet qua ban hang: " + ketQua1);
        System.out.println("\nSau khi ban 3 san pham:");
        sp1.hienThiThongTin();

        // Ban qua so luong ton kho
        System.out.println("\n===== BAN QUA SO LUONG TON KHO =====");
        System.out.println("\nTruoc khi ban:");
        sp1.hienThiThongTin();
        boolean ketQua2 = sp1.banHang(100);
        System.out.println("\nKet qua ban hang: " + ketQua2);
        System.out.println("\nSau khi ban:");
        sp1.hienThiThongTin();
    }
}