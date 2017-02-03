/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hjemmeserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 *
 * @author Frederik
 */
public class StartServer {
    public static void main(String[] args) throws IOException {
        //String ip = "192.168.0.35";
        int port = 5647;
        ServerSocket ss = new ServerSocket(port);
        //ss.bind(new InetSocketAddress(ip, port));
        while (true) {
            HomeServer e = new HomeServer(ss.accept());
            Thread t1 = new Thread(e);
            t1.start();
        }
    }
}
