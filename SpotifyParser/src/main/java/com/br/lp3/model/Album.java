package com.br.lp3.model;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Album implements Serializable {

    String albumType;
    List<Artist> artists;
    List<String> availableMarkets;
    List<Copyright> copyrights;
    ExternalId externalId;
    ExternalUrl externalUrl;
    List<String> genres;
    String href;
    String id;
    List<Image> images;
    String name;
    int popularity;
    String releaseDate;
    String releaseDatePrecision;
    Track track;
    String type;
    String uri;

}
