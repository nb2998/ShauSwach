package com.apps.nishtha.shauswach.Activities;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.apps.nishtha.shauswach.R;

public class Tutorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        Button buttonPlayVideo2 = (Button) findViewById(R.id.button2);
        getWindow().setFormat(PixelFormat.UNKNOWN);


//        long starttime= System.currentTimeMillis();
//
//        long endtime=System.currentTimeMillis();
//int point =0;
//        if((endtime-starttime)/1000>60)
//            point++;
//        //else
            //display();
//displays a video file
        VideoView mVideoView2 = (VideoView) findViewById(R.id.videoview1);
//        String uriPath2 = "C:\\Users\\NISHTHA\\AndroidStudioProjects\\ShauSwach\\app\\src\\main\\res\\raw\\toilet.mp4" + R.raw.toilet;

//        Uri uri2 = Uri.parse(uriPath2);
//        mVideoView2.setVideoURI(uri2);
        mVideoView2.requestFocus();
        mVideoView2.start();
        buttonPlayVideo2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoView mVideoView2 = (VideoView) findViewById(R.id.videoview1);
// VideoView mVideoView = new VideoView(this);
//                String uriPath = "android.resource://com.example.toyo.playvideo/" + R.raw.toilet;
//                Uri uri2 = Uri.parse(uriPath);
//                mVideoView2.setVideoURI(uri2);
//                mVideoView2.requestFocus();/
//                mVideoView2.start();
            }
        });
    }
}
