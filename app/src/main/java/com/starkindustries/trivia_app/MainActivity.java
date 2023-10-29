// Import statements for required classes and libraries
package com.starkindustries.trivia_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util Log;
import android.util Pair;
import android.view View;
import android.view animation Animation;
import android.view animation AnimationUtils;
import android.view.inputmethod InputMethodManager;
import com.android.volley Request;
import com.android.volley RequestQueue;
import com.android.volley Response;
import com.android.volley VolleyError;
import com.android.volley.toolbox JsonArrayRequest;
import com.android.volley.toolbox Volley;
import com.starkindustries.trivia_app.controller AppController;
import com.starkindustries.trivia_app.data AnswerListSyncResponse;
import com.starkindustries.trivia_app.data Repository;
import com.starkindustries.trivia_app.databinding ActivityMainBinding;
import com.starkindustries.trivia_app.model Questions;
import org.json JSONArray;
import org.json JSONException;
import org.json JSONObject;

import java.util ArrayList;

public class MainActivity extends AppCompatActivity {
    // Declare variables for data binding and animation
    ActivityMainBinding binding;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view for this activity to 'activity_main.xml'
        setContentView(R.layout.activity_main);

        // Initialize data binding for the layout
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        // Load an animation for the logo
        Animation animate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_animation);
        binding.logo.startAnimation(animate);

        // Use a Handler to create a delayed transition to another activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Define pairs of Views for shared element transition
                Pair pairs[] = new Pair[2];
                Intent inext = new Intent(getApplicationContext(), Main_Screen.class);
                pairs[0] = new Pair<View, String>(binding.logo, "app_logo");
                pairs[1] = new Pair<View, String>(binding.name, "app_name");

                // Create ActivityOptions for smooth transition animation
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                // Start the new activity with transition animation and finish this one
                startActivity(inext, options.toBundle());
                finish();
            }
        }, 2000);
    }
}
