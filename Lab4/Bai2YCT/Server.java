package Lab4.Bai2YCT;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) {
        int port = 1501;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server da khoi tao ");
            Socket socket = serverSocket.accept();
            System.out.println("Client da ket noi");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8),true);
            String input;
            while ((input = in.readLine()) != null) 
                {
                if (input.equals("QUIT")) 
                {
                    break;
                }
                String kqua;
                if (input.length() == 1 && input.charAt(0) >= '0' && input.charAt(0) <= '9') 
                    {
                    switch (input.charAt(0)) {
                        case '0':
                            kqua = "khong";
                            break;
                        case '1':
                            kqua = "mot";
                            break;
                        case '2':
                            kqua = "hai";
                            break;
                        case '3':
                            kqua = "ba";
                            break;
                        case '4':
                            kqua = "bon";
                            break;
                        case '5':
                            kqua = "nam";
                            break;
                        case '6':
                            kqua = "sau";
                            break;
                        case '7':
                            kqua = "bay";
                            break;
                        case '8':
                            kqua = "tam";
                            break;
                        case '9':
                            kqua = "chin";
                            break;
                        default:
                            kqua = "Loi, nhap lai di nao";
                    }
                } else {
                    kqua = "Loi, nhap lai di nao";
                }
                out.println(kqua);
            }
            socket.close();
            System.out.println("Client da ngat ket noi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}