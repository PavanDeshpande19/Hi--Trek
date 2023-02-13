package com.example.hi_trek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomePage extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FloatingActionButton mapbtn;

    private int selectedTab = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        final LinearLayout homelayout = findViewById(R.id.homelayout);
        final LinearLayout likelayout = findViewById(R.id.likelayout);
        final LinearLayout notificationlayout = findViewById(R.id.notificationlayout);
        final LinearLayout profilelayout = findViewById(R.id.profilelayout);

        final ImageView homeImage = findViewById(R.id.homeimg);
        final ImageView notificationImage = findViewById(R.id.notimg);
        final ImageView likeImage = findViewById(R.id.likeimg);
        final ImageView profileImage = findViewById(R.id.profimg);

        final TextView homeTxt = findViewById(R.id.hometext);
        final TextView likeTxt = findViewById(R.id.liketext);
        final TextView notificationTxt = findViewById(R.id.nottext);
        final TextView profileTxt = findViewById(R.id.proftext);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer,HomeFragment.class,null)
                .commit();
        homelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTab != 1){

                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer,HomeFragment.class,null)
                            .commit();
                    likeTxt.setVisibility(View.GONE);
                    notificationTxt.setVisibility(View.GONE);
                    profileTxt.setVisibility(View.GONE);

                    likeImage.setImageResource(R.drawable.ic_location);
                    notificationImage.setImageResource(R.drawable.ic_help);
                    profileImage.setImageResource(R.drawable.ic_account);

                    likelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationlayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profilelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    homeTxt.setVisibility(View.VISIBLE);
                    homeImage.setImageResource(R.drawable.ic_home);
                    homelayout.setBackgroundResource(R.drawable.round_back_home_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    homelayout.startAnimation(scaleAnimation);

                    selectedTab = 1;

                }
            }
        });
        likelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTab != 2){

                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer,MapFragment.class,null)
                            .commit();
                    homeTxt.setVisibility(View.GONE);
                    notificationTxt.setVisibility(View.GONE);
                    profileTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.ic_home);
                    notificationImage.setImageResource(R.drawable.ic_help);
                    profileImage.setImageResource(R.drawable.ic_account);

                    homelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationlayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profilelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    likeTxt.setVisibility(View.VISIBLE);
                    likeImage.setImageResource(R.drawable.ic_location);
                    likelayout.setBackgroundResource(R.drawable.round_back_like_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    likelayout.startAnimation(scaleAnimation);

                    selectedTab = 2;
                    Intent intent = new Intent(HomePage.this,MapsActivity.class);
                    startActivity(intent);

                }

            }
        });
        notificationlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedTab != 3){

                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer,HelpFragment.class,null)
                            .commit();
                    homeTxt.setVisibility(View.GONE);
                    likeTxt.setVisibility(View.GONE);
                    profileTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.ic_home);
                    likeImage.setImageResource(R.drawable.ic_location);
                    profileImage.setImageResource(R.drawable.ic_account);

                    homelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    likelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profilelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    notificationTxt.setVisibility(View.VISIBLE);
                    notificationImage.setImageResource(R.drawable.ic_help);
                    notificationlayout.setBackgroundResource(R.drawable.round_back_notification_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    notificationlayout.startAnimation(scaleAnimation);

                    selectedTab = 3;

                }
            }
        });
        profilelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTab != 4){

                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer,ProfileFragment.class,null)
                            .commit();
                    homeTxt.setVisibility(View.GONE);
                    likeTxt.setVisibility(View.GONE);
                    notificationTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.ic_home);
                    likeImage.setImageResource(R.drawable.ic_location);
                    notificationImage.setImageResource(R.drawable.ic_help);

                    homelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    likelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationlayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    profileTxt.setVisibility(View.VISIBLE);
                    profileImage.setImageResource(R.drawable.ic_account);
                    profilelayout.setBackgroundResource(R.drawable.round_back_profile_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    profilelayout.startAnimation(scaleAnimation);

                    selectedTab = 4;

                }
            }
        });
    }
}