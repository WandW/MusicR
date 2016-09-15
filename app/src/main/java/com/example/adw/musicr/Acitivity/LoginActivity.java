package com.example.adw.musicr.Acitivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.CircularProgressButton;
import com.example.adw.musicr.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ADW on 2016/9/2.
 */
public class LoginActivity extends Activity {
    SharedPreferences.Editor edit;
    SharedPreferences shared;
    EditText account,password;
    Button login;
    CircularProgressButton circularButton;
    android.os.Handler handler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            circularButton.setProgress(100);
            Toast.makeText(LoginActivity.this,"点击成功正在进入",Toast.LENGTH_SHORT).show();
            saveuser();
            jump();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        initData();
        setonClick();

    }
    private void initData(){
        account =(EditText)findViewById(R.id.ac);
        password =(EditText)findViewById(R.id.pw);
        circularButton = (CircularProgressButton)findViewById(R.id.login);
        login=(Button)findViewById(R.id.login);
        shared = getSharedPreferences("login",MODE_PRIVATE);
        edit = shared.edit();
        Log.i("开始检测shared里面的账号",shared.getString("account","123"));
        Log.i("开始检测shared里面的密码",shared.getString("password","123"));
        if(!shared.getString("account","null").equals("null")){
            Toast.makeText(LoginActivity.this,"已经有账号了"+shared.getString("account","null"),Toast.LENGTH_SHORT).show();
            jump();
            finish();
        }
    }
    private void setonClick(){
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(account.getText().toString().equals("")||password.getText().toString().equals("")){
//                    Toast.makeText(LoginActivity.this,"账号密码不能为空",Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(LoginActivity.this,"点击成功正在进入",Toast.LENGTH_SHORT).show();
//                    saveuser();
//                    jump();
//
//                }
//            }
//        });
        circularButton.setIndeterminateProgressMode(true);
        circularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(account.getText().toString().equals("")||password.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this,"账号密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    circularButton.setProgress(50);
                    Timer timer=new Timer();
                    TimerTask task=new TimerTask(){
                        public void run(){
                            Message msg= new Message();
                            handler.sendMessage(msg);
                        }
                    };
                    timer.schedule(task,1000*5); //呈现2秒跳转到MainActivity(主界面)中
                }
            }
        });
    }
    private void saveuser(){
        if(shared.getString("account","null").equals("null")){
            edit    .putString("account",account.getText().toString())
                    .putString("password",password.getText().toString())
                    .commit();
            Log.i("已经保存账号",account.getText().toString());
            Log.i("已经保存密码",password.getText().toString());
            Toast.makeText(LoginActivity.this,"保存成功",Toast.LENGTH_LONG).show();
        };

    }
    private void jump(){
        Intent intent= new Intent(LoginActivity.this,MainactivityT.class);
        startActivity(intent);
        finish();
    }
}
