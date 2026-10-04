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
                String result;
                if (input.length() == 1 && input.charAt(0) >= '0' && input.charAt(0) <= '9') 
                    {
                    switch (input.charAt(0)) {
                        case '0':
                            result = "khong";
                            break;
                        case '1':
                            result = "mot";
                            break;
                        case '2':
                            result = "hai";
                            break;
                        case '3':
                            result = "ba";
                            break;
                        case '4':
                            result = "bon";
                            break;
                        case '5':
                            result = "nam";
                            break;
                        case '6':
                            result = "sau";
                            break;
                        case '7':
                            result = "bay";
                            break;
                        case '8':
                            result = "tam";
                            break;
                        case '9':
                            result = "chin";
                            break;
                        default:
                            result = "Loi, nhap lai di nao";
                    }
                } else {
                    result = "Loi, nhap lai di nao";
                }
                out.println(result);
            }
            socket.close();
            System.out.println("Client da ngat ket noi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}