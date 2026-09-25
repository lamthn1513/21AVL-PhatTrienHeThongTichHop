package Lab4.Bai2YCT;

import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1502);
        System.out.println("Server dang chay...");
        Socket socket = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
        String[] number = {"không", "một", "hai", "ba", "bốn","năm", "sáu", "bảy", "tám", "chín"
        };
        String s;
        while ((s = in.readLine()) != null) {
            if (s.equals("QUIT")) {
                break;
            }
            if (s.length() == 1 && s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                int n = s.charAt(0) - '0';
                out.println(number[n]);
            } else {
            }
        }
    }
}