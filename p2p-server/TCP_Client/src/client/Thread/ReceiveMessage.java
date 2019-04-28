package client.Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceiveMessage implements Runnable {

    private String modifiedSentence;
    private final BufferedReader inFromServer;
    private final Socket clientSocket;

    public ReceiveMessage(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (clientSocket.isConnected()) {
                modifiedSentence = inFromServer.readLine();
                System.out.println(modifiedSentence);
            }
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
