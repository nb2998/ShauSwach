package com.apps.nishtha.shauswach.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.apps.nishtha.shauswach.Adapter.CardAdapter;
import com.apps.nishtha.shauswach.Card;
import com.apps.nishtha.shauswach.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recView;
    CardAdapter cardAdapter;
    ArrayList<Card> cardArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardArrayList.add(0,new Card(getString(R.string.scan), R.drawable.scan));
        cardArrayList.add(1,new Card(getString(R.string.leaderboard), R.drawable.star));
        cardArrayList.add(2,new Card(getString(R.string.tutorial), R.drawable.tutorial));

        recView= (RecyclerView) findViewById(R.id.recView);
        cardAdapter=new CardAdapter(this,cardArrayList);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(cardAdapter);

    }
}
