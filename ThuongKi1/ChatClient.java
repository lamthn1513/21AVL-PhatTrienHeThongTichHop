package ThuongKi1;


import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) 
    {
        try 
        {
            Socket socket =new Socket("localhost", 1501);
            BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            PrintWriter out =new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            BufferedReader keyboard =new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            Thread t=new Thread(() -> 
            {
                try 
                {
                    String message;
                    while ((message = in.readLine())!=null) 
                    {
                        System.out.println(message);
                    }
                } catch (Exception e) {
                    System.out.println("Mất kết nối với server");
                }
            });
            t.setDaemon(true);
            t.start();
            String text;
            while ((text = keyboard.readLine()) != null) 
            {
                out.println(text);
                if (text.equals("/exit")) 
                {
                    break;
                }
            }
            socket.close();
        } catch (Exception e) 
        {
            System.out.println("Không kết nối được tới server");
        }
    }
}
