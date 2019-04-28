package com.br.lp3.model;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Item implements Serializable {

    List<Artist> artists;
    List<String> availableMarkets;
    int discNumber;
    int duration;
    boolean explicit;
    ExternalUrl externalUrl;
    String href;
    String id;
    String name;
    String previewUrl;
    int trackNumber;
    String type;
    String uri;

}
