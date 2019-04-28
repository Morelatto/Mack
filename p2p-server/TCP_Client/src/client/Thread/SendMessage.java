package client.Thread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendMessage implements Runnable {

    private String sentence;
    private final BufferedReader inFromUser;
    private final DataOutputStream outToServer;
    private final Socket clientSocket;

    public SendMessage(Socket clientSocket) throws IOException {
        inFromUser = new BufferedReader(new InputStreamReader(System.in));
        outToServer = new DataOutputStream(clientSocket.getOutputStream());
        this.clientSocket=clientSocket;
    }

    @Override
    public void run() {
        try {
            while (clientSocket.isConnected()) {
                sentence = inFromUser.readLine();
                outToServer.writeBytes(sentence + '\n');
            }
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
