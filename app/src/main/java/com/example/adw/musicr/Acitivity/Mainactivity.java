package com.example.adw.musicr.Acitivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.adw.musicr.R;
import com.example.adw.musicr.Adpter.RecyclerViewAdpterG;

import java.util.ArrayList;

/**
 * Created by ADW on 2016/8/31.
 */
public class Mainactivity extends Activity {
    RecyclerView recyclerView;
    RecyclerViewAdpterG recyclerViewAdpter;
    ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);
//        recyclerView = (RecyclerView)findViewById(R.id.mainlistview);
//        list = new ArrayList();
//        for(int i=0;i<20;i++){
//            list.add(i);
//        }
//        Log.i("log",""+list.size());
//        recyclerViewAdpter = new RecyclerViewAdpterG(getBaseContext(),list);
//        recyclerView.setAdapter(recyclerViewAdpter);
//        // ���ò��ֹ�����
//        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
//        // ����item��
//       // recyclerView.addItemDecoration(new GridItemDecoration(this));
//        // ����item����
//        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }
}
