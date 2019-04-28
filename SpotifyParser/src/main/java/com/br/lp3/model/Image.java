package com.br.lp3.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Image implements Serializable {

    String url;
    int height;
    int width;

}
