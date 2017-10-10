package com.apps.nishtha.shauswach.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.apps.nishtha.shauswach.Classes.ToiletData;
import com.apps.nishtha.shauswach.Classes.ToiletDatabase;
import com.apps.nishtha.shauswach.R;

import java.util.ArrayList;

public class RatingActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button btnSubmit;
    Float rating;
//    FirebaseDatabase fbDb;
//    DatabaseReference dbRef;
    ToiletDatabase tdb;
    int toiletId;
  ImageButton yesbutton,nobutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        Intent intent=getIntent();

        toiletId = intent.getIntExtra("id",0);

        btnSubmit= (Button) findViewById(R.id.btnSubmit);
          yesbutton=(ImageButton) findViewById(R.id.buttonyes);
         nobutton=(ImageButton) findViewById(R.id.buttonno);
//        fbDb= FirebaseDatabase.getInstance();
//        dbRef=fbDb.getReference();
        tdb=new ToiletDatabase(this);
        setListenerOnRatingBar();
        setListenerOnButton();
    }

    private void setListenerOnRatingBar() {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rating=v;
            }
        });
    }

    private void setListenerOnButton() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rating=ratingBar.getRating();
                Toast.makeText(RatingActivity.this,String.valueOf(rating),Toast.LENGTH_SHORT).show();

                ToiletDatabase toiletDatabase=new ToiletDatabase(RatingActivity.this);
                ArrayList<ToiletData> toiletDataArrayList= (ArrayList<ToiletData>) toiletDatabase.readData();
                for(ToiletData td:toiletDataArrayList){
                    if(td.getToiletno()==toiletId){
                        //td.setRating(rating);
                        tdb.update(td);
                    }
                }
            }
        });
    }
}
