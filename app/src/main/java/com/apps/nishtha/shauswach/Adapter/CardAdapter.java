package com.apps.nishtha.shauswach.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        Card card=cardArrayList.get(position);
        holder.tvTitle.setText(card.getTitle());
        holder.ivTab.setImageResource(card.getResId());
    }

    @Override
    public int getItemCount() {
        return cardArrayList.size();
    }

    class CardHolder extends RecyclerView.ViewHolder{
        ImageView ivTab;
        TextView tvTitle;
        public CardHolder(View itemView) {
            super(itemView);
            ivTab=itemView.findViewById(R.id.ivTab);
            tvTitle=itemView.findViewById(R.id.tvTitle);
        }
    }
}
