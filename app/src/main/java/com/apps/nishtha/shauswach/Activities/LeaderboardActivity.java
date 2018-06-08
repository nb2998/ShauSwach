package com.apps.nishtha.shauswach.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.apps.nishtha.shauswach.Adapter.LBAdapter;
import com.apps.nishtha.shauswach.Classes.AreaLB;
import com.apps.nishtha.shauswach.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Cities");
        myRef.setValue(areaLBArrayList);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue();
//                Log.d("TAG", "Value is: " + value);

                lbAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

        reciewLb= (RecyclerView) findViewById(R.id.recViewLB);
        reciewLb.setLayoutManager(new LinearLayoutManager(this));
        lbAdapter=new LBAdapter(this,areaLBArrayList);
        reciewLb.setAdapter(lbAdapter);



    }
}
