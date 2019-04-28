package com.br.lp3.model;

/**
 *
 * @author Pedro
 */
public class Country {

    private String name;
    private String initials;

    public Country(String name, String initials) {
        this.name = name;
        this.initials = initials;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
}
