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
    private OnItemClickListener mListener;

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

    public interface OnItemClickListener {
        void OnItemClick(int position);
    }

    public void setOnClickListener(Friends_adapter.OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewholder holder, int position) {
        Friends_response response = friendList.get(position);
        String fName = response.getName().getFirst();
        String lName = response.getName().getLast();
        String fullName = fName +" "+ lName;

        holder.nameText.setText(fullName);
        holder.countryText.setText(response.getLocation().getCountry());
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.OnItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
