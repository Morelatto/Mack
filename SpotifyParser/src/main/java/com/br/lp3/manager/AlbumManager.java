package com.br.lp3.manager;

import com.br.lp3.model.Album;
import com.br.lp3.util.AlbumJsonParser;

import java.io.InputStream;

public class AlbumManager {

    private static final String API_JSON_FILE_NAME = "spotify.json";

    public Album getAlbum() {
        return AlbumJsonParser.parseFeed(getApiJsonFile());
    }

    private String getApiJsonFile() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(API_JSON_FILE_NAME);
        return is != null ? convertStreamToString(is) : null;
    }

    private static String convertStreamToString(InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}
