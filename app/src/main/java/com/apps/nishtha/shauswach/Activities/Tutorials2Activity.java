package com.apps.nishtha.shauswach.Activities;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.apps.nishtha.shauswach.R;

import java.io.IOException;

public class Tutorials2Activity extends AppCompatActivity {
    Button tut1, tut2, tut3, tut4;
    MediaPlayer mediaPlayer;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials2);
        tut1 = (Button) findViewById(R.id.about);
        tut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(Tutorials2Activity.this, Tutorial.class);
                startActivity(i);
            }
        });

        imageButton= (ImageButton) findViewById(R.id.btnPlayTut);
        tut2 = (Button) findViewById(R.id.stats);
        tut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(Tutorials2Activity.this, Tutorial.class);
                startActivity(i);
            }
        });

        tut3 = (Button) findViewById(R.id.register);
        tut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(Tutorials2Activity.this, Tutorial.class);
                startActivity(i);
            }
        });

        tut4 = (Button) findViewById(R.id.login);
        tut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(Tutorials2Activity.this, Tutorial.class);
                startActivity(i);
            }
        });

        mediaPlayer = new MediaPlayer();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {/**/
                    mediaPlayer.setDataSource(Tutorials2Activity.this, Uri.parse("android.resource://com.apps.nishtha.shauswach/" + R.raw.video));
                    mediaPlayer.prepareAsync();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("TAG", "onClick: " + e.getLocalizedMessage());
                }

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.start();
                    }
                });
            }
        });

    }
}
