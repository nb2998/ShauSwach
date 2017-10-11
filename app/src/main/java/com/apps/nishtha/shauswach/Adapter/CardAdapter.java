package com.apps.nishtha.shauswach.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.nishtha.shauswach.Activities.LeaderboardActivity;
import com.apps.nishtha.shauswach.Activities.ScanActivity;
import com.apps.nishtha.shauswach.Activities.Tutorials2Activity;
import com.apps.nishtha.shauswach.Card;
import com.apps.nishtha.shauswach.R;

import java.util.ArrayList;

/**
 * Created by nishtha on 10/10/17.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardHolder>{
    Context context;
    ArrayList<Card> cardArrayList;

    public CardAdapter(Context context, ArrayList<Card> cardArrayList) {
        this.context = context;
        this.cardArrayList = cardArrayList;
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardHolder(LayoutInflater.from(context).inflate(R.layout.single_row,parent,false));
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        final Card card=cardArrayList.get(position);
        holder.tvTitle.setText(card.getTitle());
        holder.ivTab.setImageResource(card.getResId());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(card.getTitle().equals(context.getResources().getString(R.string.leaderboard))){
                    Intent intent;
                    Log.e("TAG", "onClick: LB");
                    intent=new Intent(context, LeaderboardActivity.class);
                    context.startActivity(intent);
                } else if(card.getTitle().equals(context.getResources().getString(R.string.scan))){
                    Intent intent;
                    intent=new Intent(context, ScanActivity.class);
                    Log.e("Intent of scan","called");
                    context.startActivity(intent);

                } else if(card.getTitle().equals(context.getResources().getString(R.string.tutorial))){
                    Intent intent;
                    intent=new Intent(context, Tutorials2Activity.class);
                    Log.e("Intent of tutorial","called");
                    context.startActivity(intent);
                } else{

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return cardArrayList.size();
    }

    class CardHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView ivTab;
        TextView tvTitle;
        public CardHolder(View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardView);
            ivTab=itemView.findViewById(R.id.ivTab);
            tvTitle=itemView.findViewById(R.id.tvTitle);
        }
    }
}
