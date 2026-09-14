package SocketTCP;

import java.io.*;
import java.net.Socket;

public class client {
    public final static String ServerIP = "localhost";
    public final static int serverPort = 1501;
    public static void main(String[] args) {
        Socket s = null;
        try {
            s = new Socket(ServerIP, serverPort);
            System.out.println("Client đã được tạo");
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            for (int i = '1'; i<='9';i++){
                os.write(i);
                int ch = is.read();
                System.out.println((char)ch);
                Thread.sleep(2000);
            }
        } catch (Exception ie) {
            System.out.println("Lỗi: không thể tạo Socket");
        }finally {
            if(s!=null){
                try {
                    s.close();
                } catch (Exception e) {
                    System.out.println("Lỗi khi đóng Socket: " + e.getMessage());
                }
            }
        }
    }
}
