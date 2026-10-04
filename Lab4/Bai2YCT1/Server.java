package Lab4.Bai2YCT1;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1501);
            System.out.println("Server dang chay");
            while (true) 
            {
                Socket socket = serverSocket.accept();
                System.out.println("Client da ket noi");
                Thread t = new Thread(() -> xLClient(socket)); //Xử lý nhiều client
                t.start();
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    public static void xLClient(Socket socket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8 ),true);
            String input;
            while ((input = in.readLine()) != null) {
                if (input.equals("quit")) 
                {
                    System.out.println("Client da ngat ket noi");
                    break;
                }
                String kqua;
                if (input.length() == 1 && input.charAt(0) >= '0' && input.charAt(0) <= '9') 
                    {
                    switch (input.charAt(0)) {
                        case '0': kqua = "không"; break;
                        case '1': kqua = "một"; break;
                        case '2': kqua = "hai"; break;
                        case '3': kqua = "ba"; break;
                        case '4': kqua = "bốn"; break;
                        case '5': kqua = "năm"; break;
                        case '6': kqua = "sáu"; break;
                        case '7': kqua = "bảy"; break;
                        case '8': kqua = "tám"; break;
                        case '9': kqua = "chín"; break;
                        default: kqua = "Loi, nhap lai di";
                    }
                } else 
                {
                    kqua = "Loi, nhap lai di";
                }
                out.println(kqua);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}