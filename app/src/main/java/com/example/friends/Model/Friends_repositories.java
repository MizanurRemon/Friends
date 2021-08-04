package com.example.friends.Model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Friends_repositories {

    public static Friends_repositories friends_repositories;
    Friends_API friendsApi;
    MutableLiveData<Friends_list_response> message;

    private Friends_repositories() {
        friendsApi = APIUtilize.friendsApi();
    }

    public synchronized static Friends_repositories getInstance() {
        if (friends_repositories == null) {
            return new Friends_repositories();
        }
        return friends_repositories;
    }

    public @NonNull
    MutableLiveData<Friends_list_response> getMessage(@NonNull String result) {

        if (message == null) {
            message = new MutableLiveData<>();
        }

        Call<Friends_list_response> call = friendsApi.getResponse(result);

        call.enqueue(new Callback<Friends_list_response>() {
            @Override
            public void onResponse(Call<Friends_list_response> call, Response<Friends_list_response> response) {

                if (response.isSuccessful()) {
                   Friends_list_response Friends_list_response = response.body();
                    message.postValue(Friends_list_response);
                }
            }


            @Override
            public void onFailure(Call<Friends_list_response> call, Throwable t) {
               Friends_list_response response = new Friends_list_response();
                Log.d("error", t.toString());
                message.postValue(response);
            }
        });

        return message;
    }

}
