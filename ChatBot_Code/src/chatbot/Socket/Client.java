package chatbot.Socket;

import chatbot.Bot;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String args[]) throws Exception {

        // Create client socket
        Socket s = new Socket("172.21.0.187", 4999);

        //Create a client that connects to a local server
//        Socket s = new Socket("localhost", 4999);

        // to send data to the server
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        // to read data coming from the server
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String str, str1;

        Bot cb = new Bot();
        String first = "Hey, is anyone here?";
        dos.writeBytes(first + "\n");
        System.out.println("Client: " + first);

        while (!(str = cb.getChatbotResponse("end")).equals("bye")) {
            str1= br.readLine();
            System.out.println("Server: " + str1);
            if (str1.equals("end"))
                break;
            str = cb.getChatbotResponse(str1.toLowerCase());
            dos.writeBytes(str+"\n");
            System.out.println("Client: " + str);
        }

        // close connection.
        dos.close();
        br.close();
        s.close();
    }
}

