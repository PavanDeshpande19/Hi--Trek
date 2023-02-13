package com.example.hi_trek;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class HelpFragment extends Fragment {

    ImageView chat,email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_help, container, false);

        chat = view.findViewById(R.id.chat);
        email = view.findViewById(R.id.email);

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl = "https://wa.me/+918088961611?text=Hi,I need some help";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = "https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox?compose=GTvVlcSGLPnjKFWJrVrZhdxMTMSrtGqjvqwfDbZKDBsqrlbvXgXnpGsHZZbLKNCJjqNSdzlnpQdvW";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(mail));
                startActivity(intent);
            }
        });

        return view;
    }
}