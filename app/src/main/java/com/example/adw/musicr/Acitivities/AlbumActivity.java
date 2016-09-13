package com.example.adw.musicr.Acitivities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.adw.musicr.Adpter.RecyclerViewAdpter;
import com.example.adw.musicr.R;
import com.example.adw.musicr.SwitchBackLib.SwipeBackActivity;

import java.util.ArrayList;

/**
 * Created by ADW on 2016/8/31.
 */
public class AlbumActivity extends SwipeBackActivity {

    RecyclerView recyclerView;
    RecyclerViewAdpter recyclerViewAdpter;
    ArrayList list;
    TextView albumName,albumArtistName,price,creatDate;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String result = (String)msg.obj;

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.albumlayout);

//        initView();
//        recyclerView = (RecyclerView)findViewById(R.id.albumlistview);
//        list = new ArrayList();
//        for(int i=0;i<20;i++){
//            list.add(i);
//        }
//        recyclerViewAdpter = new RecyclerViewAdpter(AlbumActivity.this,list);
//        recyclerView.setAdapter(recyclerViewAdpter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.addItemDecoration(new ListItemDecoration(this, LinearLayoutManager.VERTICAL));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
//    private void initView(){
//        albumName =(TextView) findViewById(R.id.albumname);
//        albumArtistName =(TextView) findViewById(R.id.albumartist_Name);
//        creatDate =(TextView) findViewById(R.id.albumcreate_Date);
//        price =(TextView) findViewById(R.id.albumprice);
//
//    }
}
