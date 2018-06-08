package com.apps.nishtha.shauswach.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.apps.nishtha.shauswach.R;
// NOT USED NOW
public class Tutorial extends AppCompatActivity{
    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

         videoView= (VideoView) findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=5PUCdLSN0dY"));
        mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);

        videoView.start();


    }



}

