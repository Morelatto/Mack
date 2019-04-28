package com.br.lp3.ejb;

import com.br.lp3.business.PetsJSONParser;
import com.br.lp3.model.Pet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Pedro
 */
@Stateless
public class PetsManager implements PetsManagerLocal {

    private final String uri = "http://cacique.com/lp3/getAllPets/";
    private ArrayList<Pet> listaPets;

    @Override
    public ArrayList<Pet> getPets() {
        listaPets = new ArrayList<>();

        try {
            URL url = new URL(uri);
            HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();

            String str = new Scanner(sb.toString()).useDelimiter("\\A").next();
            listaPets = PetsJSONParser.parseFeed(str);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Pet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPets;
    }
}
