package com.example.friends.Model;


public class APIUtilize {
    public APIUtilize() {
    }

    public static final String BASE_URL = "https://randomuser.me/";

    public static Friends_API friendsApi() {
        return Retrofit_client.getClient(BASE_URL).create(Friends_API.class);
    }

}
