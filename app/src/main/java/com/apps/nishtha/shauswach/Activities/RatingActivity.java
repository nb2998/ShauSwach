package com.apps.nishtha.shauswach.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.apps.nishtha.shauswach.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RatingActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button btnSubmit;
    Float rating;
    //FirebaseDatabase fbDb;
  //  DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        btnSubmit= (Button) findViewById(R.id.btnSubmit);
        ratingBar= (RatingBar) findViewById(R.id.ratingBar);

//        fbDb=FirebaseDatabase.getInstance();
//        dbRef=fbDb.getReference();

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

            }
        });
    }
}
