package com.br.lp3.business;

import com.br.lp3.model.Country;
import com.br.lp3.model.Pet;
import com.br.lp3.model.State;
import java.io.StringReader;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 *
 * @author Pedro
 */
public class PetsJSONParser {

    public static ArrayList<Pet> parseFeed(String content) {
        ArrayList<Pet> listaPets = new ArrayList<>();
        JsonObject mainObj;
        try (JsonReader jsonReader = Json.createReader(new StringReader(content))) {
            mainObj = jsonReader.readObject();
        }
        int success = mainObj.getInt("success");
        if (success == 1) {
            JsonArray pets = mainObj.getJsonArray("pets");
            for (JsonValue pet : pets) {
                JsonObject petObj = (JsonObject) pet;
                listaPets.add(new Pet(petObj.getString("name"), petObj.getString("photo"), petObj.getString("description"), petObj.getString("age"), petObj.getString("race"), petObj.getString("city"), new State(petObj.getJsonObject("state").getString("name"), petObj.getJsonObject("state").getString("initials")), new Country(petObj.getJsonObject("country").getString("name"), petObj.getJsonObject("country").getString("initials"))));
            }
        }
        return listaPets;
    }
}
