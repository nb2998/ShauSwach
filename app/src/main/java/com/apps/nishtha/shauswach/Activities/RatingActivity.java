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
import android.widget.RatingBar;

import com.apps.nishtha.shauswach.Classes.ToiletData;
import com.apps.nishtha.shauswach.Classes.ToiletDatabase;
import com.apps.nishtha.shauswach.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RatingActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button btnSubmit;
    ToiletData td;
    Float rating;
    MediaPlayer mediaPlayer;
    ImageButton imageButton;
    FirebaseDatabase fbDb;
    DatabaseReference dbRef;
    ToiletDatabase tdb;
    int toiletId;
    String ToiletName;

    ImageButton yesbutton, nobutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        Intent intent = getIntent();
        tdb = new ToiletDatabase(this);
        toiletId = intent.getIntExtra("id", 0);
        final ArrayList<ToiletData> arrl = (ArrayList<ToiletData>) tdb.readData();
        imageButton = (ImageButton) findViewById(R.id.btnPlayMain);

        yesbutton = (ImageButton) findViewById(R.id.buttonyes);
        yesbutton.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             for (ToiletData temp : arrl) {
                                                 if (temp.getToiletno() == toiletId) {
                                                     temp.setYes(temp.getYes() + 1);
                                                     tdb.update(temp);
                                                     onBackPressed();
                                                     break;
                                                 }
                                             }
                                         }
                                     }

        );

        mediaPlayer = new MediaPlayer();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {/**/
                    mediaPlayer.setDataSource(RatingActivity.this, Uri.parse("android.resource://com.apps.nishtha.shauswach/" + R.raw.tickcross));
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

        nobutton = (ImageButton) findViewById(R.id.buttonno);
//        fbDb= FirebaseDatabase.getInstance();
//        dbRef=fbDb.getReference();
        //  setListenerOnRatingBar();
        //setListenerOnButton();
    }

    public void noFunc(View view) {
        final ArrayList<ToiletData> arrl = (ArrayList<ToiletData>) tdb.readData();
        for (ToiletData temp : arrl) {
            if (temp.getToiletno() == toiletId) {
                temp.setWrong(temp.getWrong() + 1);
                tdb.update(temp);
                onBackPressed();
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.e("TAG", "onBackPressed: " + e.getLocalizedMessage());
        }

    }

    //    private void setListenerOnRatingBar() {
//        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
//                rating=v;
//            }
//        });
//    }

//    private void setListenerOnButton() {
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                rating=ratingBar.getRating();
//                Toast.makeText(RatingActivity.this,String.valueOf(rating),Toast.LENGTH_SHORT).show();
//
//                ToiletDatabase toiletDatabase=new ToiletDatabase(RatingActivity.this);
//                ArrayList<ToiletData> toiletDataArrayList= (ArrayList<ToiletData>) toiletDatabase.readData();
//                for(ToiletData td:toiletDataArrayList){
//                    if(td.getToiletno()==toiletId){
//                        //td.setRating(rating);
//                        tdb.update(td);
//                    }
//                }
//            }
//        });
//    }


}
