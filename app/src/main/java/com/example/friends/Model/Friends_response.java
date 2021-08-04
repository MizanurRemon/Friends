package com.example.friends.Model;

public class Friends_response {
    private Friends_name_response name;
    private Friends_picture_response picture;
    private String nat;

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

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }
}
