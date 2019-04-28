package com.br.lp3.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Artist implements Serializable {

    ExternalUrl externalUrl;
    String href;
    String id;
    String name;
    String type;
    String uri;

}
