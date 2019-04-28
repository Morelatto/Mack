package com.br.lp3.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Copyright implements Serializable {

    String text;
    String type;

}
