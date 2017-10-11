package com.apps.nishtha.shauswach.Activities;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.apps.nishtha.shauswach.Adapter.CardAdapter;
import com.apps.nishtha.shauswach.Card;
import com.apps.nishtha.shauswach.R;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    RecyclerView recView;
    CardAdapter cardAdapter;
    ArrayList<Card> cardArrayList=new ArrayList<>();
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton= (ImageButton) findViewById(R.id.btnPlayMain);
        cardArrayList.add(0,new Card(getString(R.string.scan), R.drawable.qr));
        cardArrayList.add(1,new Card(getString(R.string.leaderboard), R.drawable.lb));
        cardArrayList.add(2,new Card(getString(R.string.tutorial), R.drawable.tut));

        recView= (RecyclerView) findViewById(R.id.recView);
        cardAdapter=new CardAdapter(this,cardArrayList);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(cardAdapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(MainActivity.this, Uri.parse("android.resource://com.apps.nishtha.shauswach.Activities/"+R.raw.swagat));
                    mediaPlayer.prepareAsync();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("TAG", "onClick: "+e.getLocalizedMessage());
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

    @Override
    protected void onStop() {
        mediaPlayer.release();
        super.onStop();
    }
}
