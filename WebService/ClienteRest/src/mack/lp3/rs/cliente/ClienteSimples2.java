package mack.lp3.rs.cliente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Pedro Morelatto
 */
public class ClienteSimples2 {

    public static void main(String[] args) throws IOException {
        HttpClient cliente = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://localhost:8080/AppExemplo-war/GerenciamentoDeOrdens/servico/submissaoOrdem");

        File file = new File("file.xml");

        InputStreamEntity reqEntity = new InputStreamEntity(
                new FileInputStream(file), -1, ContentType.TEXT_XML);
        reqEntity.setChunked(true);

        httppost.setEntity(reqEntity);

        HttpResponse response = cliente.execute(httppost);
        System.out.println("----------------------------------------");
        System.out.println(response.getStatusLine());

        HttpEntity entity = response.getEntity();

        if (entity != null) {
            try (InputStream instream = entity.getContent(); BufferedReader reader = new BufferedReader(new InputStreamReader(instream))) {
                StringBuilder out = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    out.append(line);
                }
                System.out.println(out.toString());
            }
        }
    }
}
