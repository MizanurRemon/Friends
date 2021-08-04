package com.example.friends.View.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.friends.R;
import com.squareup.picasso.Picasso;


public class Friends_details_fragment extends Fragment {

    ImageView backButton, profileImage;
    TextView nameText, streetText, cityText, stateText, countryText;

    String name, image, street, city, state, country;

    public Friends_details_fragment(String name, String image, String street, String city, String state, String country) {
        this.name = name;
        this.image = image;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        main();
    }

    private void main() {
        nameText.setText(name);
        Picasso.get().load(image).into(profileImage);
        streetText.setText(street);
        cityText.setText(city);
        stateText.setText(state);
        countryText.setText(country);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.friends_details_fragment, container, false);

        backButton = (ImageView) view.findViewById(R.id.backButtonID);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).replace(R.id.frame_container, new Home_fragment()).commit();
            }
        });

        nameText = (TextView) view.findViewById(R.id.nameTextID);
        profileImage = (ImageView) view.findViewById(R.id.profileImageID);
        streetText = (TextView) view.findViewById(R.id.streetTextID);
        cityText = (TextView) view.findViewById(R.id.cityTextID);
        stateText = (TextView) view.findViewById(R.id.stateTextID);
        countryText = (TextView) view.findViewById(R.id.countryTextID);


        return view;
    }
}