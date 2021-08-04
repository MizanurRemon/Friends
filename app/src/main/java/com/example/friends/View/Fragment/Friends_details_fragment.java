package com.example.friends.View.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friends.R;
import com.example.friends.Session.Session_Management;
import com.squareup.picasso.Picasso;


public class Friends_details_fragment extends Fragment {

    ImageView backButton, profileImage;
    TextView nameText, streetText, cityText, stateText, countryText, emailText, cellText, phoneText;

    String name, image, street, city, state, country, email, cell, phone;
    Session_Management session_management;

    public Friends_details_fragment(String name, String image, String street, String city, String state, String country, String email, String cell, String phone) {
        this.name = name;
        this.image = image;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.email = email;
        this.cell = cell;
        this.phone = phone;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        main();
    }

    private void main() {
        try {
            nameText.setText(name);
            Picasso.get().load(image).into(profileImage);
            streetText.setText(street);
            cityText.setText(city);
            stateText.setText(state);
            countryText.setText(country);
            emailText.setText(email);
            cellText.setText(cell);
            phoneText.setText(phone);
        } catch (Exception e) {
            nameText.setText(session_management.getName());
            Picasso.get().load(session_management.getSESSION_IMAGE()).into(profileImage);
            streetText.setText(session_management.getSESSION_STREET());
            cityText.setText(session_management.getSESSION_CITY());
            stateText.setText(session_management.getSESSION_STATE());
            countryText.setText(session_management.getSESSION_COUNTRY());
            emailText.setText(session_management.getSESSION_EMAIL());
            cellText.setText(session_management.getSESSION_CELL());
            phoneText.setText(session_management.getSESSION_PHONE());
        }
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
        emailText = (TextView) view.findViewById(R.id.emailTextID);
        cellText = (TextView) view.findViewById(R.id.cellTextID);
        phoneText = (TextView) view.findViewById(R.id.phoneTextID);

        emailText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + email));
                    startActivity(intent);

                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                    Log.d("ErrorXXX", e.getMessage());
                }


            }
        });

        session_management = new Session_Management(getActivity());

        return view;
    }
}