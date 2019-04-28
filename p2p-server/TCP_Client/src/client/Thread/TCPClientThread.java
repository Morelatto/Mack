package client.Thread;

import java.net.*;

class TCPClientThread {

    public static void main(String argv[]) throws Exception {
        Socket clientSocket = new Socket("172.16.16.35", 6789);

        SendMessage sm = new SendMessage(clientSocket);
        ReceiveMessage rm = new ReceiveMessage(clientSocket);

        Thread smt = new Thread(sm);
        Thread rmt = new Thread(rm);

        smt.start();
        rmt.start();
    }
}
