/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hjemmeserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Frederik
 */
public class HomeServer implements Runnable {

    Socket s;
    BufferedReader in;
    PrintWriter out;
    
    public HomeServer(Socket s){
        this.s = s;
    }
    
    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(HomeServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("Hallo User");
        while (true) {
            try {
                String mes = in.readLine();
                out.println(mes);
            } catch (Exception ex) {
                Logger.getLogger(HomeServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
