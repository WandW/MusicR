package com.example.adw.musicr.Acitivities;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adw.musicr.Adpter.RecyclerViewAdpter;
import com.example.adw.musicr.R;
import com.github.glomadrian.materialanimatedswitch.MaterialAnimatedSwitch;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by ADW on 2016/8/31.
 */
public class MainactivityT extends AppCompatActivity {


    @BindView(R.id.out)
    LinearLayout out;
    @BindView(R.id.id_left_menu)
    LinearLayout idLeftMenu;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.backdrop)
    ImageView backdrop;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.shadowDown)
    View shadowDown;
    @BindView(R.id.albumlist)
    RecyclerView albumlist;
    @BindView(R.id.mainDr)
    CoordinatorLayout mainDr;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    ArrayList l;
    RecyclerViewAdpter adpter;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.id_right_menu)
    LinearLayout idRightMenu;
    @BindView(R.id.isGrid)
    MaterialAnimatedSwitch isGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbarLayout.setTitle("Music");
        toolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle("Music");
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        setLinearLayoutManager();
        l = new ArrayList();
        for (int i = 0; i < 10; i++) {
            l.add("A" + i);
        }
        adpter = new RecyclerViewAdpter(this, l);
        albumlist.setAdapter(adpter);
        isGrid.setOnCheckedChangeListener(new MaterialAnimatedSwitch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final boolean b) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(b){
                            adpter.isGrid=true;
                            setGridLayoutManager();
                        }else{
                            adpter.isGrid=false;
                            setLinearLayoutManager();
                        }
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                                drawer.closeDrawer(GravityCompat.END);
                            }
                        }, 200);
                    }
                },300);

            }
        });

    }

    private void setLinearLayoutManager() {
        albumlist.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setGridLayoutManager() {
        albumlist.setLayoutManager(new GridLayoutManager(this, 3));
    }


}


//        initView();
//        initOnClick();
//        recyclerView = (RecyclerView)findViewById(R.id.mainlistview);
//        list = new ArrayList();
//        for(int i=0;i<20;i++){
//            list.add(i);
//        }
//        Log.i("log",""+list.size());
//        recyclerViewAdpter = new RecyclerViewAdpterG(MainactivityT.this,list);
//        recyclerView.setAdapter(recyclerViewAdpter);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());


//    private void initView() {
//        shared=getSharedPreferences("login",MODE_PRIVATE);
//        edit=shared.edit();
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        mdrawerlayout = (DrawerLayout) findViewById(R.id.mainDr);
//        toolbar.setTitle("音乐合购");
//        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        mDrawerToggle = new ActionBarDrawerToggle(this, mdrawerlayout, toolbar, R.string.open, R.string.close) {
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//            }
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//            }
//        };
//        mDrawerToggle.syncState();
//        mdrawerlayout.addDrawerListener(mDrawerToggle);
//    }
//    private void initOnClick(){
//
//        mainorder=(TextView) findViewById(R.id.order);
//        mainorder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent(OrderActivity.class);
//            }
//        });
//        loginout=(TextView)findViewById(R.id.loginout);
//        loginout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                edit.putString("account","null").putString("password","null").commit();
//                Log.i("loginout","shared cl");
//                Log.i("loginout",shared.getString("account","accl"));
//                Log.i("loginout",shared.getString("password","pwcl"));
//                Intent(LoginActivity.class);
//                finish();
//            }
//        });
//
//    }
//    private void Intent(Class c){
//        Intent intent = new Intent(MainactivityT.this,c);
//        startActivity(intent);
//        overridePendingTransition(R.anim.enter_main,R.anim.exit_main);
//    }

