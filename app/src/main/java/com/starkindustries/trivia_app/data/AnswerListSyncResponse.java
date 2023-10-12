package com.starkindustries.trivia_app.data;

import com.starkindustries.trivia_app.model.Questions;

import java.util.ArrayList;

public interface AnswerListSyncResponse {
    void processFinished(ArrayList<Questions> questionlist);
}
