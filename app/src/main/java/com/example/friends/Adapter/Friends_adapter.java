package com.example.friends.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.friends.Model.Friends_list_response;
import com.example.friends.Model.Friends_response;
import com.example.friends.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Friends_adapter extends RecyclerView.Adapter<Friends_adapter.AppViewholder>{

    private List<Friends_response> friendList;

    public Friends_adapter(List<Friends_response> friendList) {
        this.friendList = friendList;
    }


    @NonNull
    @Override
    public AppViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.friends_card, parent, false);
        return new Friends_adapter.AppViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewholder holder, int position) {
        Friends_response response = friendList.get(position);
        String fName = response.getName().getFirst();
        String lName = response.getName().getLast();
        String fullName = fName + lName;

        holder.nameText.setText(fullName);
        holder.countryText.setText(response.getNat());
        Picasso.get().load(response.getPicture().getLarge()).into(holder.friendImage);
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }

    public class AppViewholder extends RecyclerView.ViewHolder {
        ImageView friendImage;
        TextView nameText, countryText;
        public AppViewholder(@NonNull View itemView) {
            super(itemView);
            friendImage = itemView.findViewById(R.id.friendImageID);
            nameText = itemView.findViewById(R.id.nameTextID);
            countryText = itemView.findViewById(R.id.countryTextID);
        }
    }
}
