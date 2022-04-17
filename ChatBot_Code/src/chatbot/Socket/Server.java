package chatbot.Socket;

import java.io.*;
import java.net.*;

public class Server {

// Server2 class that
// receives data and sends data


    public static void main(String[] args) throws Exception {

        String str;
        // Create server Socket
        ServerSocket ss = new ServerSocket(4999);

        // connect it to client socket
        Socket s = ss.accept();
        System.out.println("Connection established");

        // to send data to the client
        PrintStream ps = new PrintStream(s.getOutputStream());

        // to read data coming from the client
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // to read data from the keyboard
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        // server executes continuously
        while (true) {
            for (int i = 0; i<=20; i++) {
                str = br.readLine();
                if(str.equals("bye"))
                    break;
                System.out.println("client: "+str);
                String ans = kb.readLine();
                System.out.println("server:" + ans);
                ps.println(ans);
            }

            // close connection
            ps.close();
            br.close();
            kb.close();
            ss.close();
            s.close();

            // terminate application
            System.exit(0);

        } // end of while
    }

}
