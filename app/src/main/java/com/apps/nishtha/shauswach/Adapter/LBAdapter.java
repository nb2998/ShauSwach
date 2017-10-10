package com.apps.nishtha.shauswach.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.nishtha.shauswach.Classes.AreaLB;
import com.apps.nishtha.shauswach.R;

import java.util.ArrayList;

/**
 * Created by nishtha on 10/10/17.
 */

public class LBAdapter extends RecyclerView.Adapter<LBAdapter.RankHolder>{
    Context context;
    ArrayList<AreaLB> userArrayList;

    public LBAdapter(Context context, ArrayList<AreaLB> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @Override
    public RankHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RankHolder(LayoutInflater.from(context).inflate(R.layout.single_row_lb,parent,false));
    }

    @Override
    public void onBindViewHolder(RankHolder holder, int position) {
        AreaLB userLB=userArrayList.get(position);
        holder.tvLbName.setText(userLB.getName());
        holder.tvLbRank.setText(String.valueOf(userLB.getRanking()));
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    class RankHolder extends ViewHolder{
        TextView tvLbRank;
        TextView tvLbName;
        public RankHolder(View itemView) {
            super(itemView);
            tvLbName=itemView.findViewById(R.id.tvLbName);
            tvLbRank=itemView.findViewById(R.id.tvLbRank);
        }
    }
}
