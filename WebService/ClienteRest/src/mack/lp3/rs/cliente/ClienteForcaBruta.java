package mack.lp3.rs.cliente;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Pedro Morelatto
 */
public class ClienteForcaBruta {

    public static void main(String[] args) throws UnknownHostException, IOException {

        String postdata = "<ordem><cliente><id>100</id><nome>Cliente X</nome></cliente>";
        postdata = postdata + "<descricao>ordem 100</descricao><id>100</id></ordem>";

        String hostname = "localhost";
        int port = 8080;

        InetAddress addr = InetAddress.getByName(hostname);

        Socket socket = new Socket(addr, port);

        String path = "/AppExemplo-war/GerenciamentoDeOrdens/servico/submissaoOrdem";

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
        bw.write("POST " + path + " HTTP/1.0\r\n");
        bw.write("Content-Length: " + postdata.length() + "\r\n");
        bw.write("Content-Type: text/xml\r\n");
        bw.write("\r\n");
        bw.write(postdata);
        bw.flush();

    }
}
