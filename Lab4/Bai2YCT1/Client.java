package Lab4.Bai2YCT1;


import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1501);
            BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8), true);                        
            Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
            while (true) 
                {
                System.out.print("Nhap so 0-9 hoac quit de thoat chuong trinh: ");
                String input = sc.nextLine();
                out.println(input);
                if (input.equals("quit")) 
                {
                    break;
                }
                String kqua = in.readLine();
                System.out.println("Server: " + kqua);
            }
            socket.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}