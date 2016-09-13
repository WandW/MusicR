package com.example.adw.musicr.Adpter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.adw.musicr.Acitivities.AlbumActivity;
import com.example.adw.musicr.R;

import java.util.ArrayList;

/**
 * Created by ADW on 2016/8/31.
 */
public class RecyclerViewAdpterG extends RecyclerView.Adapter<RecyclerViewAdpterG.ItemViewHolder>{
    ArrayList list;
    LayoutInflater mInflater;
    Context context;
    public RecyclerViewAdpterG(Context baseContext, ArrayList mlist) {
        list = mlist;
        mInflater = LayoutInflater.from(baseContext);
        context=baseContext;
    }



    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       ItemViewHolder holder = new ItemViewHolder(
               mInflater.inflate(R.layout.item_album_g,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder( ItemViewHolder holder, int position) {
        holder.staggernum.setText(position+"");
        holder.albumicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, AlbumActivity.class);
                context.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private  TextView staggernum;
        private RelativeLayout albumicon;
        public ItemViewHolder(View itemView) {
            super(itemView);
            staggernum = (TextView)itemView.findViewById(R.id.count);
            albumicon=(RelativeLayout)itemView.findViewById(R.id.albumicon);
//            LinearLayoutCompat.LayoutParams params = (LinearLayoutCompat.LayoutParams) staggernum.getLayoutParams();
//            LinearLayoutCompat.LayoutParams params2 = new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
//            albumicon.addView(albumicon,params2);
        }

    }
}
