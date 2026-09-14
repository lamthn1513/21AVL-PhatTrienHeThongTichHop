package SocketTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public final static int serverPort= 1501;

    public static void main(String[] args)
    {   
        try{
            ServerSocket ss = new ServerSocket(serverPort);
            System.out.println("Server đã được tạo");
            while (true) {
                try{
                    Socket s=ss.accept();
                    OutputStream os = s.getOutputStream();
                    InputStream is = s.getInputStream();
                    int ch = 0;
                    while (true) {
                        ch = is.read();
                        if(ch == -1) break;
                        System.out.println((char)ch);
                        os.write(ch);
                    }
                    s.close();
                }catch(IOException ie1){
                    System.out.println("Kết nối thất bại "+ie1);
                }
            }
        }catch(IOException ie){
            System.out.println("Lỗi tạo máy chủ"+ie);
        }
    }
}
