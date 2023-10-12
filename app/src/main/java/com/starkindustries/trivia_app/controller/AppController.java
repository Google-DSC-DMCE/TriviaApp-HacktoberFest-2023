package com.starkindustries.trivia_app.controller;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {
public static AppController instance;
public RequestQueue queue;
public static synchronized AppController getInstance()
{
    return instance;
}
public RequestQueue getQueue()
{
    if(queue==null)
        queue = Volley.newRequestQueue(getApplicationContext());
    return queue;
}
public <T> void addToRequestQueue(Request<T> request)
{
    getQueue().add(request);
}

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }
}
