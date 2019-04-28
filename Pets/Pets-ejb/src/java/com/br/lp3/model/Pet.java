package com.br.lp3.model;

/**
 *
 * @author Pedro
 */
public class Pet {

    private String name;
    private String photo;
    private String description;
    private String age;
    private String race;
    private String city;
    private State state;
    private Country country;

    public Pet(String name, String photo, String description, String age, String race, String city, State state, Country country) {
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.age = age;
        this.race = race;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
