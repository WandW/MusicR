package com.example.adw.musicr.Adpter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adw.musicr.Acitivities.OrderCheckActivity;
import com.example.adw.musicr.R;

import java.util.ArrayList;

/**
 * Created by ADW on 2016/8/31.
 */
public class RecyclerViewAdpterL extends RecyclerView.Adapter<RecyclerViewAdpterL.ItemViewHolder>{
    ArrayList list;
    LayoutInflater mInflater;
    Context context;
    public RecyclerViewAdpterL(Context baseContext, ArrayList mlist) {
        list = mlist;
        mInflater = LayoutInflater.from(baseContext);
        this.context=baseContext;
    }
    
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       ItemViewHolder holder = new ItemViewHolder(
               mInflater.inflate(R.layout.orderitemlayout,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder( ItemViewHolder holder, int position) {
        holder.name.setText("Q"+list.get(position)+"歌曲名字");
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("跳转至OrderCheckActivity","成功");
                Intent i= new Intent(context,OrderCheckActivity.class);
                context.startActivity(i);
                Log.i("跳转至OrderCheckActivity","成功2");
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class ItemViewHolder extends RecyclerView.ViewHolder{
        private  TextView name;
        public ItemViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.ordersingname);
        }

    }
}
