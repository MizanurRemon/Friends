package com.example.friends.View.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.friends.Adapter.Friends_adapter;
import com.example.friends.Model.Friends_list_response;
import com.example.friends.R;
import com.example.friends.ViewModel.Friends_ViewModel;

import java.util.ArrayList;
import java.util.List;

public class Home_fragment extends Fragment {

    RecyclerView friendView;
    Friends_ViewModel friendsViewModel;
    String result = "10";
    private Friends_list_response friendList;
    private Friends_adapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        main();
    }

    private void main() {
        friendsViewModel.getData(result).observe(getViewLifecycleOwner(), new Observer<Friends_list_response>() {
            @Override
            public void onChanged(Friends_list_response friends_list_responses) {
                friendList = new Friends_list_response();
                friendList = friends_list_responses;
                adapter = new Friends_adapter(friendList.getResults());
                friendView.setAdapter(adapter);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        friendsViewModel = new ViewModelProvider(this).get(Friends_ViewModel.class);

        friendView = (RecyclerView) view.findViewById(R.id.friendViewID);
        friendView.setHasFixedSize(true);
        friendView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return view;
    }
}