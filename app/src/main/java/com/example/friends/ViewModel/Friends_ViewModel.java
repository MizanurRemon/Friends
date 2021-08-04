package com.example.friends.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.friends.Model.Friends_list_response;
import com.example.friends.Model.Friends_repositories;
import com.example.friends.Model.Friends_response;

import java.util.List;

public class Friends_ViewModel extends AndroidViewModel {

    public Friends_ViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Friends_list_response> getData(String result) {

        return Friends_repositories.getInstance().getMessage(result);

    }
}
