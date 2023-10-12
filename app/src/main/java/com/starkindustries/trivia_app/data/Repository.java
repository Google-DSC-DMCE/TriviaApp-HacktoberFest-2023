package com.starkindustries.trivia_app.data;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.starkindustries.trivia_app.controller.AppController;
import com.starkindustries.trivia_app.model.Questions;

import org.json.JSONArray;

import java.util.ArrayList;

public class Repository {
    public String url="https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";
    public ArrayList<Questions> getQuestion(final AnswerListSyncResponse calback)
    {
        ArrayList<Questions> questions = new ArrayList<Questions>();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

        @Override
        public void onResponse(JSONArray response) {
            for(int i=0;i<response.length();i++)
            {
                try{
                    questions.add(new Questions(response.getJSONArray(i).getString(0),response.getJSONArray(i).getBoolean(1)));
//                    Log.d("ironman",questions.toString());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if(null!=calback)
                calback.processFinished(questions);
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d("Ironman","Failed to Parse Data");
        }
    });
    AppController.getInstance().addToRequestQueue(request);
    return questions;
    }
}
