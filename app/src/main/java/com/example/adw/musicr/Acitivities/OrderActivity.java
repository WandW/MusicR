package com.example.adw.musicr.Acitivities;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.adw.musicr.Adpter.RecyclerViewAdpterL;
import com.example.adw.musicr.R;
import com.example.adw.musicr.SwitchBackLib.SwipeBackActivity;
import com.example.adw.musicr.jar.ListItemDecoration;

import java.util.ArrayList;

/**
 * Created by ADW on 2016/8/31.
 */
public class OrderActivity extends SwipeBackActivity {
    RecyclerView recyclerView;
    RecyclerViewAdpterL recyclerViewAdpterl;
    ArrayList list;
//    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderlayout);
        recyclerView = (RecyclerView)findViewById(R.id.orderlistview);
        list = new ArrayList();
        for(int i=0;i<20;i++){
            list.add(i);
        }
        Log.i("log",""+list.size());
        recyclerViewAdpterl = new RecyclerViewAdpterL(OrderActivity.this,list);
        recyclerView.setAdapter(recyclerViewAdpterl);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 设置item分
        recyclerView.addItemDecoration(new ListItemDecoration(this, LinearLayoutManager.VERTICAL));
        // 设置item动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_order,R.anim.exit_order);
    }
    //    private void initOnClick(){
//        back =(Button) findViewById(R.id.orderback);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(OrderActivity.this,"退出",Toast.LENGTH_SHORT).show();
//                finish();
//
//            }
//        });
//
//
//
//    }
}
