package com.example.hi_trek;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends Fragment {
    CardView cardview1,cardview2,cardview3,cardview4,cardview5,cardview6,cardview7,cardview8;
    TextView nanditext,skandatext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        cardview1 = view.findViewById(R.id.cardview1);
        cardview2 = view.findViewById(R.id.cardview2);
        nanditext = view.findViewById(R.id.nanditext);
        skandatext = view.findViewById(R.id.skandatext);
        cardview3 = view.findViewById(R.id.cardview3);
        cardview4 = view.findViewById(R.id.cardview4);
        cardview5 = view.findViewById(R.id.cardview5);
        cardview6 = view.findViewById(R.id.cardview6);
        cardview7 = view.findViewById(R.id.cardview7);
        cardview8 = view.findViewById(R.id.cardview8);

        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),NandiHills.class);
                startActivity(intent);
            }
        });
        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),SkandaGiri.class);
                startActivity(intent);
            }
        });
        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MakaliDurga.class);
                startActivity(intent);
            }
        });
        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),SavanDurga.class);
                startActivity(intent);
            }
        });
        cardview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Kumara.class);
                startActivity(intent);
            }
        });
        cardview6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Kudremukh.class);
                startActivity(intent);
            }
        });
        cardview7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),KabbeHills.class);
                startActivity(intent);
            }
        });
        cardview8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Tadiandamol.class);
                startActivity(intent);
            }
        });

        return view;
    }

}