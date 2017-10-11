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

        areaLBArrayList.add(0,new AreaLB("Badli",1));
        areaLBArrayList.add(1,new AreaLB("Kondli",2));
        areaLBArrayList.add(2,new AreaLB("Gharoli",3));
        areaLBArrayList.add(3,new AreaLB("Dallo Pura",4));
        areaLBArrayList.add(4,new AreaLB("Gharonda",5));

        reciewLb= (RecyclerView) findViewById(R.id.recViewLB);
        reciewLb.setLayoutManager(new LinearLayoutManager(this));
        lbAdapter=new LBAdapter(this,areaLBArrayList);
        reciewLb.setAdapter(lbAdapter);

    }
}
