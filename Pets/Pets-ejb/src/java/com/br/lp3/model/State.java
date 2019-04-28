package com.br.lp3.model;

/**
 *
 * @author Pedro
 */
public class State {

    private String name;
    private String initials;

    public State(String name, String initials) {
        this.name = name;
        this.initials = initials;
    }

    public State() {
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
