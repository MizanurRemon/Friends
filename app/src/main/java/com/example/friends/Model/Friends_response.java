package com.example.friends.Model;

public class Friends_response {
    private Friends_name_response name;
    private Friends_picture_response picture;
    private Friends_location_response location;

    public Friends_location_response getLocation() {
        return location;
    }

    public void setLocation(Friends_location_response location) {
        this.location = location;
    }

    public Friends_name_response getName() {
        return name;
    }

    public void setName(Friends_name_response name) {
        this.name = name;
    }

    public Friends_picture_response getPicture() {
        return picture;
    }

    public void setPicture(Friends_picture_response picture) {
        this.picture = picture;
    }

}
