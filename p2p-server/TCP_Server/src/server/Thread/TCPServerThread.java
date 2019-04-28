package server.Thread;

import java.net.*;

class TCPServerThread {

    public static void main(String argv[]) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);

        System.out.println("\tAguardando Conexão\n");
        
        Conexao c1 = new Conexao(welcomeSocket);
        Conexao c2 = new Conexao(welcomeSocket);
        
        c1.setTargetClient(c2.getThisClient());
        c2.setTargetClient(c1.getThisClient());
        
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        
        t1.start();
        t2.start();
    }
}
