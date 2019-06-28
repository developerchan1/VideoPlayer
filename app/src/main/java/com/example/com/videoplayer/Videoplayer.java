package com.example.com.videoplayer;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class Videoplayer extends AppCompatActivity {

    VideoView videoView;
    String uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_videoplayer);

        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        uri = getIntent().getExtras().getString("uri");
        videoView= findViewById(R.id.videoView);

        videoView.setVideoPath(uri);
        videoView.start();
        MediaController mediaController = new MediaController(Videoplayer.this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);


    }
}
