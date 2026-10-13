package ThuongKi1;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ChatServer {
    static ArrayList<Client> clients = new ArrayList<>();
    public static void main(String[] args) {
        try {
            ServerSocket sv=new ServerSocket(1501);
            int port=1501;
            System.out.println("Server đang khởi tạo tại Port "+port);
            while (true) 
            {
                Socket socket= sv.accept();
                Client c = new Client(socket);
                clients.add(c);
                c.start();
            }
        } catch (Exception e) {
            System.out.println("Lỗi khởi tạo server");
        }
    }

    static class Client extends Thread {
        Socket socket;
        BufferedReader in;
        PrintWriter out;
        String name;
        String room = "";
        Client(Socket socket) {this.socket = socket;}
        public void run() 
        {
            try {
                in= new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                out= new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
                out.println("Nhập tên của bạn: ");
                name = in.readLine();
                System.out.println(name + " đã kết nối");
                while (true) {
                    out.println("DANH SÁCH PHÒNG CHAT");
                    out.println("-------------------");
                    out.println("Study");
                    out.println("Game");
                    out.println("TraiNghiem");
                    out.println("-------------------");
                    out.println("Nhập tên phòng muốn vào");
                    out.println("Nhập /exit để thoát");
                    String choice = in.readLine();
                    if (choice==null || choice.equals("/exit")) 
                    {
                        break;
                    }
                    if (choice.equalsIgnoreCase("Study")||choice.equalsIgnoreCase("Game")
                                                                ||choice.equalsIgnoreCase("TraiNghiem")) 
                    {
                        room = choice;
                        out.println("Chào mừng " + name + " đến với phòng " + room);
                        out.println("Nhập tin nhắn để gửi đến mọi người trong phòng");
                        out.println("Nhập /quit để rời phòng");
                        out.println("Nhập /exit để thoát");
                        while (true) 
                        {
                            String message= in.readLine();
                            if (message==null||message.equals("/exit")) 
                            {
                                return;
                            }

                            if (message.equals("/quit")) 
                            {
                                room= "";
                                out.println("Bạn đã rời phòng "+choice);
                                break;
                            }

                            if (!message.isEmpty()) 
                            {
                                sendMessage(name+": "+message);
                            }
                        }
                    } 
                    else 
                    {
                        out.println("Phòng không tồn tại, vui lòng chọn lại");
                    }
                }
            } catch (Exception e) {
                System.out.println("Cleint đã ngắt kết nối: "+socket.getInetAddress().getHostAddress());
            } finally {
                clients.remove(this);
                try 
                {
                    socket.close();
                } catch (Exception e) 
                {
                    System.out.println("Lỗi đống socket");
                }
                System.out.println(name+" đã thoát");
            }
        }

        void sendMessage(String message) 
        {
            System.out.println("["+room+"] "+message);
            synchronized (clients) 
            {
                for (Client c:clients) 
                {
                    if (c!=this && !room.isEmpty()&&room.equalsIgnoreCase(c.room)) 
                    {
                        c.out.println(message);
                    }
                }
            }
        }
    }
}
