package com.apps.nishtha.shauswach.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.apps.nishtha.shauswach.Adapter.LBAdapter;
import com.apps.nishtha.shauswach.Classes.AreaLB;
import com.apps.nishtha.shauswach.R;

import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity {

    RecyclerView reciewLb;
    LBAdapter lbAdapter;
    ArrayList<AreaLB> areaLBArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        areaLBArrayList.add(0,new AreaLB("Village 1",1));
        areaLBArrayList.add(1,new AreaLB("Village 2",2));
        areaLBArrayList.add(2,new AreaLB("Village 3",3));

        reciewLb= (RecyclerView) findViewById(R.id.recViewLB);
        reciewLb.setLayoutManager(new LinearLayoutManager(this));
        lbAdapter=new LBAdapter(this,areaLBArrayList);
        reciewLb.setAdapter(lbAdapter);

    }
}
