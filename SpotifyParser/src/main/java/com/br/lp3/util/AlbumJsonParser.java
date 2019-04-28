package com.br.lp3.util;

import com.br.lp3.model.Album;
import com.br.lp3.model.Artist;
import com.br.lp3.model.Copyright;
import com.br.lp3.model.ExternalId;
import com.br.lp3.model.ExternalUrl;
import com.br.lp3.model.Image;
import com.br.lp3.model.Item;
import com.br.lp3.model.Track;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class AlbumJsonParser {

    private AlbumJsonParser() {
    }

    public static Album parseFeed(String content) {
        JsonObject mainObj;
        try (JsonReader jsonReader = Json.createReader(new StringReader(content))) {
            mainObj = jsonReader.readObject();
        }

        return Album
                .builder()
                .albumType(mainObj.getString("album_type"))
                .artists(getArtists(mainObj.getJsonArray("artists")))
                .availableMarkets(getAvailableMarkets(mainObj))
                .copyrights(getCopyrights(mainObj.getJsonArray("copyrights")))
                .externalId(getExternalId(mainObj))
                .externalUrl(getExternalUrl(mainObj))
                .genres(getGenres(mainObj.getJsonArray("genres")))
                .href(mainObj.getString("href"))
                .id(mainObj.getString("id"))
                .images(getImages(mainObj.getJsonArray("images")))
                .name(mainObj.getString("name"))
                .popularity(mainObj.getInt("popularity"))
                .releaseDate(mainObj.getString("release_date"))
                .releaseDatePrecision(mainObj.getString("release_date_precision"))
                .track(getTrack(mainObj.getJsonObject("tracks")))
                .type(mainObj.getString("type"))
                .uri(mainObj.getString("uri"))
                .build();
    }

    private static List<Artist> getArtists(JsonArray artistsArray) {
        return IntStream
                .range(0, artistsArray.size())
                .mapToObj(artistsArray::getJsonObject)
                .map(artist -> Artist
                        .builder()
                        .externalUrl(getExternalUrl(artist))
                        .href(artist.getString("href"))
                        .id(artist.getString("id"))
                        .name(artist.getString("name"))
                        .type(artist.getString("type"))
                        .uri(artist.getString("uri"))
                        .build())
                .collect(Collectors.toList());
    }

    private static ExternalUrl getExternalUrl(JsonObject jsonObject) {
        JsonObject externalUrls = jsonObject.getJsonObject("external_urls");
        return externalUrls != null ? new ExternalUrl(externalUrls.getString("spotify")) : null;
    }

    private static ExternalId getExternalId(JsonObject jsonObject) {
        JsonObject externalIds = jsonObject.getJsonObject("external_ids");
        return externalIds != null ? new ExternalId(externalIds.getString("upc")) : null;
    }

    private static List<String> getAvailableMarkets(JsonObject jsonObject) {
        JsonArray availableMarketsArray = jsonObject.getJsonArray("available_markets");
        return IntStream
                .range(0, availableMarketsArray.size())
                .mapToObj(i -> availableMarketsArray.getJsonString(i).getString())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static List<Copyright> getCopyrights(JsonArray copyrightsArray) {
        return IntStream
                .range(0, copyrightsArray.size())
                .mapToObj(copyrightsArray::getJsonObject)
                .map(copyright -> Copyright
                        .builder()
                        .text(copyright.getString("text"))
                        .type(copyright.getString("type"))
                        .build())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static List<String> getGenres(JsonArray genresArray) {
        return IntStream
                .range(0, genresArray.size())
                .mapToObj(genresArray::getString)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static ArrayList<Image> getImages(JsonArray imagesArray) {
        return IntStream
                .range(0, imagesArray.size())
                .mapToObj(imagesArray::getJsonObject)
                .map(image -> Image
                        .builder()
                        .url(image.getString("url"))
                        .height(image.getInt("height"))
                        .width(image.getInt("width"))
                        .build())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static Track getTrack(JsonObject track) {
        return Track
                .builder()
                .href(track.getString("href"))
                .items(getItems(track.getJsonArray("items")))
                .limit(track.getJsonNumber("limit").intValue())
                .next(track.get("next").toString())
                .offset(track.getJsonNumber("offset").intValue())
                .previous(track.get("previous").toString())
                .total(track.getJsonNumber("total").intValue())
                .build();
    }

    private static List<Item> getItems(JsonArray itemsArray) {
        return IntStream
                .range(0, itemsArray.size())
                .mapToObj(itemsArray::getJsonObject)
                .filter(item -> item != null && !item.isEmpty())
                .map(item -> Item
                        .builder()
                        .artists(getArtists(item.getJsonArray("artists")))
                        .availableMarkets(getAvailableMarkets(item))
                        .discNumber(item.getInt("disc_number"))
                        .duration(item.getInt("duration_ms"))
                        .explicit(item.getBoolean("explicit"))
                        .externalUrl(getExternalUrl(item))
                        .href(item.getString("href"))
                        .id(item.getString("id"))
                        .name(item.getString("name"))
                        .previewUrl(item.getString("preview_url"))
                        .trackNumber(item.getInt("track_number"))
                        .type(item.getString("type"))
                        .uri(item.getString("uri"))
                        .build())
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
