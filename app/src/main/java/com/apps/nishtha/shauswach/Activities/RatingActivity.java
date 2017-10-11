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

import java.util.*;

public class RatingActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button btnSubmit;
    ToiletData td;
    Float rating;
//    FirebaseDatabase fbDb;
//    DatabaseReference dbRef;
    ToiletDatabase tdb;
    int toiletId;
    String ToiletName;

  ImageButton yesbutton,nobutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        Intent intent=getIntent();
        tdb=new ToiletDatabase(this);
        toiletId = intent.getIntExtra("id",0);
        final ArrayList<ToiletData> arrl= (ArrayList<ToiletData>) tdb.readData();

          yesbutton=(ImageButton) findViewById(R.id.buttonyes);
        yesbutton.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                          for(ToiletData temp:arrl){
                                              if(temp.getToiletno()==toiletId)
                                              {
                                                  temp.setYes(temp.getYes()+1);
                                                  tdb.update(temp);
                                                  break;
                                              }
                                          }
                                         }
                                     }
        );
         nobutton=(ImageButton) findViewById(R.id.buttonno);
//        fbDb= FirebaseDatabase.getInstance();
//        dbRef=fbDb.getReference();
      //  setListenerOnRatingBar();
        //setListenerOnButton();
    }

    public void noFunc(View view) {
        final ArrayList<ToiletData> arrl= (ArrayList<ToiletData>) tdb.readData();
        for(ToiletData temp:arrl){
            if(temp.getToiletno()==toiletId)
            {
                temp.setWrong(temp.getWrong()+1);
                tdb.update(temp);
                break;
            }
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
