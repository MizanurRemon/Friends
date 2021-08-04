package com.example.friends.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Session_Management {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String SHARED_PREF_NAME = "session";
    String SESSION_NAME = "SESSION_NAME";
    String SESSION_IMAGE = "SESSION_IMAGE";
    String SESSION_STREET = "SESSION_STREET";
    String SESSION_CITY = "SESSION_CITY";
    String SESSION_STATE = "SESSION_STATE";
    String SESSION_COUNTRY = "SESSION_COUNTRY";
    String SESSION_EMAIL = "SESSION_EMAIL";
    String SESSION_CELL = "SESSION_CELL";
    String SESSION_PHONE = "SESSION_PHONE";


    public Session_Management(Context con) {
        sharedPreferences = con.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(String name, String image, String street, String city, String state, String country, String email, String cell, String phone) {
        String nameS = name;
        String imageS = image;
        String streetS = street;
        String cityS = city;
        String stateS = state;
        String countryS = country;
        String emailS = email;
        String cellS = cell;
        String phoneS = phone;

        editor.putString(SESSION_NAME, nameS);
        editor.putString(SESSION_IMAGE, imageS);
        editor.putString(SESSION_STREET, streetS);
        editor.putString(SESSION_CITY, cityS);
        editor.putString(SESSION_STATE, stateS);
        editor.putString(SESSION_COUNTRY, countryS);
        editor.putString(SESSION_EMAIL, emailS);
        editor.putString(SESSION_CELL, cellS);
        editor.putString(SESSION_PHONE, phoneS);


        editor.commit();

    }

    public String getName() {
        return sharedPreferences.getString(SESSION_NAME, "");
    }

    public String getSESSION_IMAGE() {
        return sharedPreferences.getString(SESSION_IMAGE, "");
    }

    public String getSESSION_STREET() {
        return sharedPreferences.getString(SESSION_STREET, "");
    }

    public String getSESSION_CITY() {
        return sharedPreferences.getString(SESSION_CITY, "");
    }

    public String getSESSION_STATE() {
        return sharedPreferences.getString(SESSION_STATE, "");
    }

    public String getSESSION_COUNTRY() {
        return sharedPreferences.getString(SESSION_COUNTRY, "");
    }

    public String getSESSION_EMAIL() {
        return sharedPreferences.getString(SESSION_EMAIL, "");
    }

    public String getSESSION_CELL() {
        return sharedPreferences.getString(SESSION_CELL, "");
    }

    public String getSESSION_PHONE() {
        return sharedPreferences.getString(SESSION_PHONE, "");
    }
    /*public void removeSession() {
        editor.putString(SESSION_KEY, "-1").commit();
    }*/
}
