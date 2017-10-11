package com.apps.nishtha.shauswach.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.apps.nishtha.shauswach.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class Tutorials2Activity extends AppCompatActivity {
Button tut1,tut2,tut3,tut4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials2);
        tut1=(Button)findViewById(R.id.about);
        tut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent();
                i.setClass(Tutorials2Activity.this, Tutorial.class);
                startActivity(i);
            }
        });

        tut2=(Button)findViewById(R.id.stats);
        tut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent();
                i.setClass(Tutorials2Activity.this,Tutorial.class );
                startActivity(i);
            }
        });

        tut3=(Button)findViewById(R.id.register);
        tut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent();
                i.setClass(Tutorials2Activity.this,Tutorial.class );
                startActivity(i);
            }
        });

        tut4=(Button)findViewById(R.id.login);
        tut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent();
                i.setClass(Tutorials2Activity.this, Tutorial.class );
                startActivity(i);
            }
        });

    }
}
