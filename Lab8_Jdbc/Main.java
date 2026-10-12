
package Lab8_Jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:Lab8_Jdbc/database/dbase.db");
            stmt = conn.createStatement();

            //Tạo bảng nv
            // stmt.executeUpdate("CREATE TABLE NhanVien (id INTEGER PRIMARY KEY, ten TEXT NOT NULL, chuc_vu TEXT)");
            conn.setAutoCommit(false);

            //Tạo bảng sp
            // stmt.executeUpdate(
            //     "CREATE TABLE SanPham (" +
            //     "maSP INTEGER PRIMARY KEY, " +
            //     "tenSP TEXT NOT NULL, " +
            //     "gia REAL NOT NULL, " +
            //     "soluong INTEGER NOT NULL)"
            // );
            try {

                //Thêm nv
                // stmt.executeUpdate("INSERT INTO NhanVien VALUES (1, 'Nguyễn Văn An', 'Giám đốc')");
                // stmt.executeUpdate("INSERT INTO NhanVien VALUES (2, 'Trần Thị Binh', 'Kế toán')");
                // stmt.executeUpdate("INSERT INTO NhanVien VALUES (3, 'Lê Văn Cương', 'Nhân viên')");
                // stmt.executeUpdate("INSERT INTO NhanVien VALUES (4, 'Trần Thị A', 'Nhân viên')");


                //Thêm sp
                // stmt.executeUpdate( "INSERT INTO SanPham VALUES (1, 'Laptop', 15000000, 10)");
                // stmt.executeUpdate("INSERT INTO SanPham VALUES (2, 'Chuột', 250000, 20)");
                // stmt.executeUpdate("INSERT INTO SanPham VALUES (3, 'Bàn phím', 500000, 15)");

                //Xóa
                // stmt.executeUpdate("DELETE FROM NhanVien WHERE id =1");
                // stmt.executeUpdate("DELETE FROM NhanVien WHERE id =3");

                //Chỉnh sửa
                //stmt.executeUpdate("UPDATE NhanVien SET chuc_vu ='Quản lý' WHERE id =2");

                //Lưu
                conn.commit();
                System.out.println("Lưu thành công");

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Lỗi lưu SQL");
                e.printStackTrace();
            }

            //Hiên thị danh sách nv
            rs = stmt.executeQuery("SELECT * FROM NhanVien");
            System.out.println("DANH SÁCH NHÂN VIÊN");
            System.out.printf("%-5s %-20s %-15s%n", "ID", "Tên", "Chức vụ");
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-15s%n",
                    rs.getInt("id"),
                    rs.getString("ten"),
                    rs.getString("chuc_vu"));
            }

            //Hiên thị danh sách sp
            System.out.println("\nDANH SÁCH SẢN PHẨM");
            System.out.printf("%-8s %-20s %-15s %-10s%n","Mã SP", "Tên SP", "Giá", "Số lượng");
            rs = stmt.executeQuery("SELECT * FROM SanPham");

            while (rs.next()) {
            System.out.printf("%-8d %-20s %-15.0f %-10d%n",
                    rs.getInt("maSP"),
                    rs.getString("tenSP"),
                    rs.getDouble("gia"),
                    rs.getInt("soluong")
                );
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy JBDC Driver");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Lỗi SQL");
            e.printStackTrace();
        } finally {
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
}
