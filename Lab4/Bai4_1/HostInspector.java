package Lab4.Bai4_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostInspector {
    public static void main(String[] args) {
        if(args.length!=1){         
            System.out.println("Usage: java network.HostInspector <hostname>");
            return;
        }

        try {
            InetAddress[] addresses = InetAddress.getAllByName(args[0]);
            System.out.println("Host: "+args[0]);
            for (InetAddress address : addresses){
                System.out.println("- IP: "+address.getHostAddress());
                System.out.println(" Canonical: "+address.getCanonicalHostName());
                System.out.println(" Loopback: "+address.isLoopbackAddress());
                System.out.println(" Site Local: "+address.isSiteLocalAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("Không phân giải được Host: "+args[0]);
        }
    }
}
