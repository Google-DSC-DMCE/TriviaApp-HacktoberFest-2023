package com.starkindustries.trivia_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.starkindustries.trivia_app.controller.AppController;
import com.starkindustries.trivia_app.data.AnswerListSyncResponse;
import com.starkindustries.trivia_app.data.Repository;
import com.starkindustries.trivia_app.databinding.ActivityMainBinding;
import com.starkindustries.trivia_app.model.Questions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding=DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        Animation animate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo_animation);
        binding.logo.startAnimation(animate);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Pair pairs[] = new Pair[2];
                Intent inext = new Intent(getApplicationContext(),Main_Screen.class);
                pairs[0]=new Pair<View,String>(binding.logo,"app_logo");
                pairs[1]=new Pair<View,String>(binding.name,"app_name");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(inext,options.toBundle());
                finish();
            }
        },2000);
    }
}