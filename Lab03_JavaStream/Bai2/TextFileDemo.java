    package Tuan3.Bai2;
    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.IOException;
    import java.nio.charset.StandardCharsets;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.StandardOpenOption;
    public class TextFileDemo {
        public static void main(String[] args) {
            Path file = Path.of("data", "ghichu.txt");

            //Mở rộng 2:
            System.out.println("Đường dẫn tuyệt đối: " + file.toAbsolutePath());
            
            try {Files.createDirectories(file.getParent());

                try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
                    writer.write("Java I/O làm việc với các luồng dữ liệu.");
                    writer.newLine();
                    writer.write("BufferedWriter giúp ghi văn bản hiệu quả.");
                    writer.newLine();
                    writer.write("UTF-8 hỗ trợ tiếng Việt ổn định.");
                    writer.newLine();
                }

                //Mở rộng 1:
                try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8,StandardOpenOption.CREATE,StandardOpenOption.APPEND)) {
                    writer.write("Đây là dòng được ghi thêm.");
                    writer.newLine();
                }

                //Mở rộng 3: Nếu thay UTF-8 thành charset khác thì các ký tư tiếng Việt sẽ hiển thị sai
                try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
                    String line;
                    int number = 1;
                    while ((line = reader.readLine()) != null) {
                        System.out.printf("%d. %s%n", number++, line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Lỗi xử lý tệp " + file + ": "
                    + e.getMessage());
            }
        }
    }