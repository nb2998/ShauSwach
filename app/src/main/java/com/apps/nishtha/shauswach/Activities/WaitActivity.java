package com.apps.nishtha.shauswach.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.apps.nishtha.shauswach.Classes.UserData;
import com.apps.nishtha.shauswach.Classes.UserDatabase;
import com.apps.nishtha.shauswach.R;

public class WaitActivity extends AppCompatActivity {

    TextView tvTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        tvTimer= (TextView) findViewById(R.id.tvTimer);

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTimer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tvTimer.setText("done!");
            }
        }.start();

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                //start your activity here
                UserDatabase ubdata=new UserDatabase(WaitActivity.this);
                UserData ud=ubdata.readData();
                ud.setCnt(1);
                ubdata.update(ud);
                int toiletno = getIntent().getIntExtra("id1", 0);
                Intent intent;
                intent = new Intent(WaitActivity.this, ScanActivity.class);
                intent.putExtra("id", toiletno);
                startActivity(intent);
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("result",toiletno);
//                setResult(Activity.RESULT_OK,returnIntent);
                finish();

            }

        }, 10000);


    }
}
