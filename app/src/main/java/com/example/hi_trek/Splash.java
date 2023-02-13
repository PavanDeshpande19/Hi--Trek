package com.example.hi_trek;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;

public class Splash extends AppCompatActivity {
    VideoView videoView;
    Button btn;
    ImageView imageView;
    public static int UPDATE_CODE = 22;
    AppUpdateManager appUpdateManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_splash);

        btn = findViewById(R.id.getstarted);
        videoView = findViewById(R.id.videoView);
        imageView = findViewById(R.id.splashimg);

        String path = new StringBuilder("android.resource://")
                .append(getPackageName())
                .append("/raw/walk")
                .toString();
//"android.resource://com.thebreakingdown.HiTrek/"+R.raw.png;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                imageView.setVisibility(View.GONE);
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
            }
        });
        inAppUp();

    }

    private void inAppUp() {
        appUpdateManager = AppUpdateManagerFactory.create(this);
        Task<AppUpdateInfo> task = appUpdateManager.getAppUpdateInfo();
        task.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
            @Override
            public void onSuccess(AppUpdateInfo appUpdateInfo) {

                if(appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)
                ){
                    try {
                        appUpdateManager.startUpdateFlowForResult(appUpdateInfo,AppUpdateType.FLEXIBLE,
                        Splash.this,
                                UPDATE_CODE
                        );
                    } catch (IntentSender.SendIntentException e) {
                        e.printStackTrace();
                        Log.d("updateerror","onSuccess"+e.toString());
                    }
                }
            }
        });

        appUpdateManager.registerListener(listener);
    }

    InstallStateUpdatedListener listener = installState -> {
        if(installState.installStatus() == InstallStatus.DOWNLOADED){
            popUp();
        }
    };

    private void popUp() {
        Snackbar snackbar = Snackbar.make(
                findViewById(android.R.id.content),
                "App Update Almost Done",
                Snackbar.LENGTH_INDEFINITE
        );
        snackbar.setAction("Reload", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appUpdateManager.completeUpdate();
            }
        });
        snackbar.setTextColor(Color.parseColor("#FF0000"));
        snackbar.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == UPDATE_CODE){
            if((resultCode != RESULT_OK)){

            }
        }
    }
}