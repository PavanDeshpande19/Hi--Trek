package com.example.hi_trek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class KabbeHills extends AppCompatActivity {
    ImageView arrowup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabbe_hills);
        arrowup = (ImageView) findViewById(R.id.second_arrow_up);
        arrowup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KabbeHills.this,KabbeHills2.class);
                startActivity(intent);
            }
        });
    }
}