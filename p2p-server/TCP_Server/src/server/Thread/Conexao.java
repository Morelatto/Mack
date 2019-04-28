package server.Thread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexao implements Runnable {

    private String sentence;
    private final Socket connectionSocket;
    private final BufferedReader inFromClient;
    private String nome;
    private final String address;
    private DataOutputStream targetClient;
    private final DataOutputStream thisClient;
    private static String iniciarConversa;

    public Conexao(ServerSocket welcomeSocket) throws IOException {
        iniciarConversa = null;
        this.connectionSocket = welcomeSocket.accept();
        inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        thisClient = new DataOutputStream(connectionSocket.getOutputStream());
        address = "(" + connectionSocket.getRemoteSocketAddress().toString().substring(1) + ")";
    }

    public DataOutputStream getThisClient() throws IOException {
        return thisClient;
    }

    public void setTargetClient(DataOutputStream targetClient) {
        this.targetClient = targetClient;
    }

    public synchronized void iniciaConversa() throws IOException {
        if (iniciarConversa != null) {
            System.out.println("\n\tIniciando Conversa\n");
            targetClient.writeBytes("\n\tIniciando conversa com " + nome + address + ".\n\n");
            thisClient.writeBytes("\n\tIniciando conversa com " + iniciarConversa + ".\n\n");
        } else {
            iniciarConversa = this.nome + address;
        }
    }

    @Override
    public void run() {
        String capitalizedSentence;
        try {
            thisClient.writeBytes("\tDigite o seu nome:\n");
            String nome = inFromClient.readLine();
            this.nome = nome;
            System.out.println(this.nome + address + " conectado.");
            iniciaConversa();
            while (connectionSocket.isConnected()) {
                sentence = inFromClient.readLine();
                capitalizedSentence = nome + ": " + sentence + "\n";
                targetClient.writeBytes(capitalizedSentence);
                System.out.print(capitalizedSentence);
            }
            connectionSocket.close();
        } catch (Exception ex) {
            System.out.println("deu merda - " + ex.getMessage());
        }
    }

}
