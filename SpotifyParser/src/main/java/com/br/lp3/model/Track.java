package com.br.lp3.model;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Track implements Serializable {

    String href;
    List<Item> items;
    int limit;
    String next;
    int offset;
    String previous;
    int total;

}
