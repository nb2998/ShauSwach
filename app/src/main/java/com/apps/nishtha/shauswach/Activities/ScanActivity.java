package com.apps.nishtha.shauswach.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.nishtha.shauswach.Classes.ToiletData;
import com.apps.nishtha.shauswach.Classes.ToiletDatabase;
import com.apps.nishtha.shauswach.Classes.UserDatabase;
import com.apps.nishtha.shauswach.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ScanActivity extends AppCompatActivity {

    private Button buttonScan;
    private TextView textViewName, textViewAddress,textViewRewardPoints;
    ToiletDatabase tdb;
    UserDatabase udb;
    //qr code scanner object
    public IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("scanActivity","started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        udb=new UserDatabase(this);
        tdb=new ToiletDatabase(this);
        buttonScan = (Button) findViewById(R.id.buttonScan);
//        textViewName = (TextView) findViewById(R.id.textViewName);
//        textViewAddress = (TextView) findViewById(R.id.textViewAddress);
        textViewRewardPoints=(TextView) findViewById(R.id.textViewRewardPoints);
        //intializing scan object
        Log.e("scanActivity2","started");

        Log.e("scanActivity3","started");
        buttonScan.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                qrScan.initiateScan();
            }
        });
        qrScan = new IntentIntegrator(this);
        Log.e("scanActivity4","started");
        textViewRewardPoints.setText(String.valueOf("You have "+udb.readData().getRwdpts())+" points.");
        Log.e("scanActivity5","started");
    }
    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.e("onActivityResult","started");
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        int toiletno;
        String toiletname;

        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    toiletno=Integer.parseInt(obj.getString("Toilet no"));
                    toiletname=obj.getString("Location");
                    ToiletData td=new ToiletData(toiletno,toiletname);
//                    textViewName.setText(String.valueOf(toiletno));
//                    textViewAddress.setText(toiletname);
                    List<ToiletData> toiletDataList=tdb.readData();
                    if(toiletDataList.contains(td)){

                    }
                    else
                    {
                        tdb.addData(td);
                    }
                    udb.addData();
                    textViewRewardPoints.setText(String.valueOf(udb.readData()));

                    Intent intent;
                    intent=new Intent(ScanActivity.this, RatingActivity.class);
                    intent.putExtra("id",toiletno);
                    Log.e("Intent","called");
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
