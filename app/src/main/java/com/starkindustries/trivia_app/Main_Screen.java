package com.starkindustries.trivia_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.starkindustries.trivia_app.data.AnswerListSyncResponse;
import com.starkindustries.trivia_app.data.Repository;
import com.starkindustries.trivia_app.databinding.ActivityMainScreenBinding;
import com.starkindustries.trivia_app.model.Questions;

import java.util.ArrayList;

public class Main_Screen extends AppCompatActivity {
    ActivityMainScreenBinding binding;
    public int current_question=1;
    public int right_answer=0;
    public int wrong_answer=0;

    ArrayList<Questions> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        binding = DataBindingUtil.setContentView(Main_Screen.this,R.layout.activity_main_screen);
        list = new Repository().getQuestion(new AnswerListSyncResponse() {
            @Override
            public void processFinished(ArrayList<Questions> questionlist) {
                current_question=((current_question+1)%list.size());
                binding.count.setText("Count: "+current_question+"/"+list.size());
                binding.question.setText(questionlist.get(current_question).getQuestion());
             }
        });
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mainBackground.setBackgroundColor(Color.DKGRAY);
                current_question=((current_question+1)%list.size());
                binding.count.setText("Count: "+current_question+"/"+list.size());
                binding.question.setText(list.get(current_question).getQuestion());
            }
        });
        binding.previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mainBackground.setBackgroundColor(Color.DKGRAY);
                current_question=((current_question-1)%list.size());
                binding.count.setText("Count: "+current_question+"/"+list.size());
                binding.question.setText(list.get(current_question).getQuestion());
            }
        });
        binding.True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean actual_ans=list.get(current_question).isAnswer();
                if(actual_ans)
                {
                    binding.rightAnswer.setText(String.valueOf(++right_answer));
                    binding.mainBackground.setBackgroundColor(Color.GREEN);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            binding.mainBackground.setBackgroundColor(Color.DKGRAY);
                        }
                    },1000);
                    current_question=((current_question+1)%list.size());
                    binding.count.setText("Count: "+current_question+"/"+list.size());
                    binding.question.setText(list.get(current_question).getQuestion());
                }
                else {
                    binding.wronganswer.setText(String.valueOf(++wrong_answer));
                    binding.mainBackground.setBackgroundColor(Color.RED);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            binding.mainBackground.setBackgroundColor(Color.DKGRAY);
                        }
                    },1000);
                    current_question=(current_question+1)%list.size();
                    binding.count.setText("Count: "+current_question+"/"+list.size());
                    binding.question.setText(list.get(current_question).getQuestion());
                }

            }
        });
        binding.False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean answer=list.get(current_question).isAnswer();
                if(!answer)
                {
                    binding.rightAnswer.setText(String.valueOf(++right_answer));
                    binding.mainBackground.setBackgroundColor(Color.GREEN);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            binding.mainBackground.setBackgroundColor(Color.DKGRAY);
                        }
                    },1000);
                    current_question=((current_question+1)%list.size());
                    binding.count.setText("Count: "+current_question+"/"+list.size());
                    binding.question.setText(list.get(current_question).getQuestion());
                }
                else
                {
                    binding.wronganswer.setText(String.valueOf(++wrong_answer));
                    binding.mainBackground.setBackgroundColor(Color.RED);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            binding.mainBackground.setBackgroundColor(Color.DKGRAY);
                        }
                    },1000);
                    current_question=((current_question+1)%list.size())+1;
                    binding.count.setText("Count: "+current_question+"/"+list.size());
                    binding.question.setText(list.get(current_question).getQuestion());
                }
            }
        });
        binding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_question=0;
                right_answer=0;
                wrong_answer=0;
                binding.wronganswer.setText(String.valueOf(wrong_answer));
                binding.rightAnswer.setText(String.valueOf(right_answer));
                binding.count.setText("Count: "+(current_question+1)+"/"+list.size());
                binding.question.setText(list.get(current_question).getQuestion());
            }
        });
    }
}