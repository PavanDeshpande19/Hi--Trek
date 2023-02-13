package com.example.hi_trek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NandiHills2 extends AppCompatActivity {
    FloatingActionButton nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nandi_hills2);
        nav = findViewById(R.id.map);

        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NandiHills2.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}