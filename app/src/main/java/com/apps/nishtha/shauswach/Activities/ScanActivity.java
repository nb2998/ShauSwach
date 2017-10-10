package com.apps.nishtha.shauswach.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private TextView textViewName, textViewAddress;
    ToiletDatabase tdb;
    UserDatabase udb;
    //qr code scanner object
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        buttonScan = (Button) findViewById(R.id.buttonScan);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewAddress = (TextView) findViewById(R.id.textViewAddress);
        //intializing scan object
        qrScan = new IntentIntegrator(this);
        buttonScan.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                qrScan.initiateScan();
            }
        });

    }
    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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
                    //setting values to textviews
                    toiletno=Integer.parseInt(obj.getString("Toilet no"));
                    //textViewName.setText(obj.getString("Toilet no"));
                    toiletname=obj.getString("Location");
                    //textViewAddress.setText(obj.getString("Location"));
                    ToiletData td=new ToiletData(toiletno,toiletname);
                    textViewName.setText(toiletno);
                    textViewAddress.setText(toiletname);

                    List<ToiletData> toiletDataList=tdb.readData();
                    if(toiletDataList.contains(td)){

                    }
                    else
                    {
                        tdb.addData(td);
                    }
                    udb.addData();

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
