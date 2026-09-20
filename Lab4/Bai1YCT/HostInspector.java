package Lab4.Bai1YCT;

import java.net.*;

public class HostInspector {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java Lab4.Bai1YCT.HostInspector <hostname> <URI>");
            return;
        }
        String hostname = args[0];
        String uriText = args[1];

        try {
            InetAddress[] addresses = InetAddress.getAllByName(hostname);
            System.out.println("Host: " + hostname);
            for (InetAddress address : addresses) {
                System.out.println("IP: " + address.getHostAddress());
                if (address instanceof Inet4Address)
                    System.out.println("Type: IPv4");
                else if (address instanceof Inet6Address)
                    System.out.println("Type: IPv6");
                System.out.println("Loopback: " + address.isLoopbackAddress());
                System.out.println("Site Local: " + address.isSiteLocalAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println("ERROR: HOST_NOT_FOUND");
            return;
        }
        try {
            URI uri = new URI(uriText);
            System.out.println("\nURI: " + uriText);
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());
        } catch (URISyntaxException e) {
            System.out.println("ERROR: INVALID_URI");
        }
    }
}