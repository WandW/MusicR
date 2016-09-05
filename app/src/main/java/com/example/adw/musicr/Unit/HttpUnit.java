package com.example.adw.musicr.Unit;

/**
 * Created by ADW on 2016/9/2.
 */
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;




public class HttpUnit extends Thread {
    Context context;
    Handler handler;
    Message message;
    String result;
    String path;
    public  String action;
    public	String rootNet="http://www.var123.cn:1065/E_Change/";
    public HttpUnit(Context context, Handler handler) {
        // TODO 自动生成的构造函数存根
        this.context=context;
        this.handler=handler;
        message=new Message();
    }
    @Override
    public void run() {
        // TODO 自动生成的方法存根
        path=rootNet+action;
        URL url;
        String result = "";

        try {
            url = new URL(path);
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            Log.i("msg",result);
            message.obj=result;
            handler.sendMessage(message);
            //message.obj = result;
            // handler.sendMessage(message);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };
    }



}