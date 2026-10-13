package Lab8_Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:Lab8_Jdbc/database/dbase.db");
            stmt = conn.createStatement();

            // Tao bang SanPham
            stmt.executeUpdate("CREATE TABLE SanPham (maSP INTEGER PRIMARY KEY, tenSP TEXT NOT NULL, gia REAL NOT NULL, soluong INTEGER NOT NULL)");

            // Them 3 san pham mau neu bang chua co du lieu
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM SanPham");
            if (rs.next() && rs.getInt(1) == 0) 
            {
                stmt.executeUpdate("INSERT INTO SanPham VALUES (1, 'Laptop', 15000000, 10)");
                stmt.executeUpdate("INSERT INTO SanPham VALUES (2, 'Chuột', 250000, 20)");
                stmt.executeUpdate("INSERT INTO SanPham VALUES (3, 'Bàn phím', 500000, 15)");
            }
            rs.close();
            int chon;
            do {
                System.out.println("\nQUẢN LÝ SẢN PHẨM");
                System.out.println("1. Thêm sản phẩm");
                System.out.println("2. Hiển thị sản phẩm");
                System.out.println("3. Tìm sản phẩm theo tên");
                System.out.println("4. Cập nhật sản phẩm");
                System.out.println("5. Xóa sản phẩm");
                System.out.println("0. Thoát");
                System.out.print("Nhập lựa chọn: ");
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        themSanPham(conn, sc);
                        break;
                    case 2:
                        hienThiSanPham(conn);
                        break;
                    case 3:
                        timSanPham(conn, sc);
                        break;
                    case 4:
                        capNhatSanPham(conn, sc);
                        break;
                    case 5:
                        xoaSanPham(conn, sc);
                        break;
                    case 0:
                        System.out.println("Kết thúc chương trình");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ");
                }
            } while (chon != 0);
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy driver JDBC");

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối cơ sở dữ liệu");
            e.printStackTrace();

        } catch (NumberFormatException e) {
            System.out.println("Dữ liệu nhập phải là số hợp lệ.");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                sc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Them san pham
    public static void themSanPham(Connection conn, Scanner sc) 
    {
        Statement stmt = null;
        try {
            System.out.print("Nhập mã SP: ");
            int ma = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập tên SP: ");
            String ten = sc.nextLine().replace("'", "''");
            System.out.print("Nhập giá: ");
            double gia = Double.parseDouble(sc.nextLine());
            System.out.print("Nhập số lượng: ");
            int sl = Integer.parseInt(sc.nextLine());
            if (ten.trim().isEmpty() || gia < 0 || sl < 0) 
            {
                System.out.println("Dữ liệu không hợp lệ");
                return;
            }
            stmt = conn.createStatement();
            String sql = "INSERT INTO SanPham VALUES (" + ma + ", '" + ten + "', " + gia + ", " + sl + ")";
            stmt.executeUpdate(sql);
            System.out.println("Thêm sản phẩm thành công.");
        } catch (SQLException e) 
        {
            System.out.println("Thêm sản phẩm thất bại.");
            e.printStackTrace();
        } finally 
            {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Hien thi danh sach san pham
    public static void hienThiSanPham(Connection conn) 
    {
        Statement stmt = null;
        ResultSet rs = null;
        try 
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM SanPham");
            System.out.println("\nDANH SÁCH SẢN PHẨM");
            System.out.printf("%-8s %-20s %-15s %-10s%n", "Mã SP", "Tên SP", "Giá", "Số lượng");
            while (rs.next()) {
                System.out.printf("%-8d %-20s %-15.0f %-10d%n",
                    rs.getInt("maSP"),
                    rs.getString("tenSP"),
                    rs.getDouble("gia"),
                    rs.getInt("soluong"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try 
            {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Tim san pham theo ten
    public static void timSanPham(Connection conn, Scanner sc) 
    {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            System.out.print("Nhập tên SP cần tìm: ");
            String ten = sc.nextLine().replace("'", "''");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM SanPham WHERE tenSP LIKE '%" + ten + "%'");
            boolean timThay = false;
            while (rs.next()) {
                timThay = true;
                System.out.println(
                    rs.getInt("maSP") + " - " +
                    rs.getString("tenSP") + " - Gia: " +
                    rs.getDouble("gia") + " - So luong: " +
                    rs.getInt("soluong")
                );
            }
            if (!timThay) 
            {
                System.out.println("Khong tim thay san pham.");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Cap nhat gia va so luong
    public static void capNhatSanPham(Connection conn, Scanner sc) 
    {
        Statement stmt = null;
        try {
            System.out.print("Nhập mã SP cần sửa: ");
            int ma = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập giá mới: ");
            double gia = Double.parseDouble(sc.nextLine());

            System.out.print("Nhập số lượng mới: ");
            int sl = Integer.parseInt(sc.nextLine());

            if (gia < 0 || sl < 0) 
            {
                System.out.println("Giá và số lượng phải >= 0.");
                return;
            }
            stmt = conn.createStatement();
            int n = stmt.executeUpdate(
                "UPDATE SanPham SET gia = " + gia +
                ", soluong = " + sl + " WHERE maSP = " + ma);
            if (n > 0) 
            {
                System.out.println("Cập nhật thành công.");
            } 
            else 
            {
                System.out.println("Không tìm thấy mã SP");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Xoa san pham
    public static void xoaSanPham(Connection conn, Scanner sc) 
    {
        Statement stmt = null;
        try {
            System.out.print("Nhập mã SP cần xóa: ");
            int ma = Integer.parseInt(sc.nextLine());
            stmt = conn.createStatement();
            int n = stmt.executeUpdate("DELETE FROM SanPham WHERE maSP = " + ma);
            if (n > 0) 
            {
                System.out.println("Xóa thành công.");
            } 
            else 
            {
                System.out.println("Không tìm thấy mã SP");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}