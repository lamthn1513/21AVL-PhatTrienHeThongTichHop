package Lab2_OPP.Bai1;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private double donGia;
    private int soLuong;

    public SanPham(String maSanPham, String tenSanPham, double donGia, int soLuong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double tinhThanhTien() {
        return donGia * soLuong;
    }

    public void nhapHang(int soLuongNhap) {
        if (soLuongNhap > 0) {
            soLuong = soLuong + soLuongNhap;
        } else {
            System.out.println("So luong nhap phai lon hon 0!");
        }
    }

    public boolean banHang(int soLuongBan) {

        if (soLuongBan <= 0) {
            System.out.println("So luong ban phai lon hon 0!");
            return false;
        }
        if (soLuongBan > soLuong) {
            System.out.println("Khong du hang de ban!");
            return false;
        }
        soLuong = soLuong - soLuongBan;
        return true;
    }

    public void hienThiThongTin() {
        System.out.println("Ma san pham: " + maSanPham);
        System.out.println("Ten san pham: " + tenSanPham);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Thanh tien: " + tinhThanhTien());
    }
}
