package com.example.adw.musicr.Acitivities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adw.musicr.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ADW on 2016/8/31.
 */
public class Mainactivity extends AppCompatActivity {


    @BindView(R.id.set)
    LinearLayout set;
    @BindView(R.id.out)
    LinearLayout out;
    @BindView(R.id.id_left_menu)
    LinearLayout idLeftMenu;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.id_right_menu)
    LinearLayout idRightMenu;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.shadowDown)
    View shadowDown;
//    @BindView(R.id.albumlist)
//    RecyclerView albumlist;
    @BindView(R.id.mainDr)
    CoordinatorLayout mainDr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbarLayout.setTitle("Music");
        toolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle("Music");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
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
