package com.example.hi_trek;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.VideoView;


public class ProfileFragment extends Fragment {
    CardView logout,help,share;

    public static final String SHARED_PREFS="sharedPrefs";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        logout = view.findViewById(R.id.logout);
        help = view.findViewById(R.id.helpprof);
        share = view.findViewById(R.id.share);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name","");
                editor.apply();
                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),HelpFragment.class);
                startActivity(intent);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = "The best views come with the hardest climb”.Share our app to experience it with ur friends.Download it for free!https://play.google.com/store/apps/details?="+BuildConfig.APPLICATION_ID+"\n\n";
                String shareSub = "Hi-Trek";
                //String shareMessage = "https://play.google.com/store/apps/details?="+BuildConfig.APPLICATION_ID+"\n\n";
                //intent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                intent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(intent,"Share By"));
            }
        });
        return view;
    }
}