package Lab2_OPP.Bai2;

public class Main {

    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien(
                "Nguyen Van An",
                2005,
                "TP HCM",
                "SV01",
                "Cong nghe thong tin",
                8.8
        );

        SinhVien sv2 = new SinhVien(
                "Tran Thi Binh",
                2004,
                "Can Tho",
                "SV02",
                "Ke toan",
                6.5
        );

        GiangVien gv1 = new GiangVien(
                "Nguyen Van Nam",
                1980,
                "TP HCM",
                "GV01",
                "Lap trinh Java",
                10000000,
                2.5
        );

        GiangVien gv2 = new GiangVien(
                "Tran Van Minh",
                1978,
                "Dong Nai",
                "GV02",
                "Co so du lieu",
                12000000,
                2.8
        );

        System.out.println("         SINH VIEN 1");
        sv1.hienThiThongTin();
        System.out.println("         SINH VIEN 2");
        sv2.hienThiThongTin();
        System.out.println("         GIANG VIEN 1");
        gv1.hienThiThongTin();
        System.out.println("         GIANG VIEN 2");
        gv2.hienThiThongTin();
    }
}