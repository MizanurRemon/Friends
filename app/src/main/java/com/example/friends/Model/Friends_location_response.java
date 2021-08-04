package com.example.friends.Model;

public class Friends_location_response {

    private  Friends_street_response street;

    public Friends_street_response getStreet() {
        return street;
    }

    public void setStreet(Friends_street_response street) {
        this.street = street;
    }

    String city, state, country;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
