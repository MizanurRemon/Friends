package com.example.friends.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Friends_API {

    @GET("/api")
    Call<Friends_list_response> getResponse(@Query("results") String results);
}
