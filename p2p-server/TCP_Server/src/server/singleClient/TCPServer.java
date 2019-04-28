package server.singleClient;

import java.io.*;
import java.net.*;

class TCPServer {

    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        String nome;
        ServerSocket welcomeSocket = new ServerSocket(6789);

        System.out.println("\tAguardando Conexão\n");

        Socket connectionSocket = welcomeSocket.accept();
        nome="Client(" + connectionSocket.getRemoteSocketAddress().toString().substring(1)+")";
        System.out.println(nome+" conectado.");

        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream client = new DataOutputStream(connectionSocket.getOutputStream());

        System.out.println("\n\tIniciando Conversa\n");

        try {
            while (true) {
                clientSentence = inFromClient.readLine();
                capitalizedSentence = nome + ": " + clientSentence + "\n";
                client.writeBytes(capitalizedSentence);
                System.out.print(capitalizedSentence);
            }
        } catch (Exception ex) {
            System.out.println("deu merda - " + ex.getMessage());
        }
    }
}
