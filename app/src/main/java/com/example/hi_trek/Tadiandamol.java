package com.example.hi_trek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Tadiandamol extends AppCompatActivity {
    ImageView arrowup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tadiandamol);
        arrowup = (ImageView) findViewById(R.id.second_arrow_up);
        arrowup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tadiandamol.this,Tadiandamol2.class);
                startActivity(intent);
            }
        });
    }
}