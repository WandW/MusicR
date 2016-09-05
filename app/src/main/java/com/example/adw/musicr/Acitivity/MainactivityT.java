package com.example.adw.musicr.Acitivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.adw.musicr.Adpter.RecyclerViewAdpterG;
import com.example.adw.musicr.R;

import java.util.ArrayList;

/**
 * Created by ADW on 2016/8/31.
 */
public class MainactivityT extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdpterG recyclerViewAdpter;
    ArrayList list;
    Toolbar toolbar;
    DrawerLayout mdrawerlayout;
    ActionBarDrawerToggle mDrawerToggle;
    TextView mainorder,loginout;
    SharedPreferences shared;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout_t);
        initView();
        initOnClick();
        recyclerView = (RecyclerView)findViewById(R.id.mainlistview);
        list = new ArrayList();
        for(int i=0;i<20;i++){
            list.add(i);
        }
        Log.i("log",""+list.size());
        recyclerViewAdpter = new RecyclerViewAdpterG(MainactivityT.this,list);
        recyclerView.setAdapter(recyclerViewAdpter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
    private void initView() {
        shared=getSharedPreferences("login",MODE_PRIVATE);
        edit=shared.edit();
        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        mdrawerlayout = (DrawerLayout) findViewById(R.id.mainDr);
        toolbar.setTitle("音乐合购");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this, mdrawerlayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mdrawerlayout.addDrawerListener(mDrawerToggle);
    }
    private void initOnClick(){

        mainorder=(TextView) findViewById(R.id.mainorder);
        mainorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent(OrderActivity.class);
            }
        });
        loginout=(TextView)findViewById(R.id.loginout);
        loginout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.putString("account","null").putString("password","null").commit();
                Log.i("loginout","shared cl");
                Log.i("loginout",shared.getString("account","accl"));
                Log.i("loginout",shared.getString("password","pwcl"));
                Intent(LoginActivity.class);
                finish();
            }
        });

    }
    private void Intent(Class c){
        Intent intent = new Intent(MainactivityT.this,c);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_main,R.anim.exit_main);
    }
}
