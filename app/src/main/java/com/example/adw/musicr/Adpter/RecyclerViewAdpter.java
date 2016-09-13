package com.example.adw.musicr.Adpter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adw.musicr.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ADW on 2016/8/31.
 */
public class RecyclerViewAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final static int TYPE_LIST = 1;
    public final static int TYPE_GRID = 2;
    ArrayList list;
    Context context;
    public boolean isGrid = false;
    public int selectedid = 0;

    public RecyclerViewAdpter(Context context, ArrayList mlist) {
        list = mlist;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return (isGrid) ? TYPE_GRID : TYPE_LIST;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_LIST) {
            View v = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.item_album_l, parent, false);
            RecyclerView.ViewHolder vh = new ListViewHolder(v);
            return vh;
        } else {
            View v = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.item_album_g, parent, false);
            RecyclerView.ViewHolder vh = new GridViewHolder(v);
            return vh;
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewholder, int position) {
        if(isGrid){
            GridViewHolder holder = (GridViewHolder)viewholder;
            holder.count.setText("1111");
            holder.icon.setImageURI(Uri.parse("http://cf.mora.jp/contents/package/0000/00000177/0007/697/355/0007697355.200.jpg"));
        }else {
            ListViewHolder holder = (ListViewHolder)viewholder;
            holder.voter.setText("11112");
            holder.albumicon.setImageURI(Uri.parse("http://cf.mora.jp/contents/package/0000/00000177/0007/697/355/0007697355.200.jpg"));
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.albumicon)
        SimpleDraweeView albumicon;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.info)
        TextView info;
        @BindView(R.id.tag)
        RecyclerView tag;
        @BindView(R.id.voter)
        TextView voter;
        @BindView(R.id.date)
        TextView date;

        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }


    static class GridViewHolder  extends RecyclerView.ViewHolder{
        @BindView(R.id.icon)
        SimpleDraweeView icon;
        @BindView(R.id.count)
        TextView count;
        @BindView(R.id.singer)
        TextView singer;

        GridViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}



