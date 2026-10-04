package Lab4.Bai2YCT;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1501;
        try (Socket socket = new Socket(host, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8),true);
            Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
            System.out.println("Da ket noi den Server");
            while (true) {
                System.out.print("Nhap so 0 den 9 hoac nhap QUIT de thoat: ");
                String input = sc.nextLine();

                //Gui du lieu
                out.println(input);

                //Thoat chuong trinh
                if (input.equals("QUIT")) {
                    break;
                }
                //Nhan ket qua
                String response = in.readLine();
                System.out.println("Server: " + response);
            }
            sc.close();
            System.out.println("Da ngat ket noi");
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}