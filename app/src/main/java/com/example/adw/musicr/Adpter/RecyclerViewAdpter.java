package com.example.adw.musicr.Adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adw.musicr.R;

import java.util.ArrayList;

/**
 * Created by ADW on 2016/8/31.
 */
public class RecyclerViewAdpter extends RecyclerView.Adapter<RecyclerViewAdpter.ItemViewHolder>{
    ArrayList list;
    LayoutInflater mInflater;
    Context context;
    public RecyclerViewAdpter(Context baseContext, ArrayList mlist) {
        list = mlist;
        mInflater = LayoutInflater.from(baseContext);
        this.context=baseContext;
    }
    
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       ItemViewHolder holder = new ItemViewHolder(
               mInflater.inflate(R.layout.albumitemlist,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder( ItemViewHolder holder, int position) {
        holder.num.setText(position+"数字");
        holder.name.setText("Q"+list.get(position));

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private  TextView name;
        private  TextView num;
        public ItemViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.albumitemlistname);
            num = (TextView) itemView.findViewById(R.id.albumitemlistnum);
        }

    }
}
