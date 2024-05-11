package com.example.offlinequiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView questions;
    private TextView question;

    private AppCompatButton option1, option2, option3, option4;

    private AppCompatButton nextBtn;

    private Timer quizTimer;

    private int totalTimeInMins = 1;

    private int seconds = 0;

    private List<QuestionsList> questionslists;

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView backBtn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.quizTimer);
        final TextView selectedTopicName = findViewById(R.id.topicName);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        nextBtn = findViewById(R.id.nextBtn);


        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");

        selectedTopicName.setText(getSelectedTopicName);

        questionslists = QuestionsBank.getQuestions(getSelectedTopicName);

        startTimer(timer);

        questions.setText((currentQuestionPosition + 1) + "/" + questionslists.size());
        question.setText(questionslists.get(0).getQuestion());
        option1.setText(questionslists.get(0).getOption1());
        option2.setText(questionslists.get(0).getOption2());
        option3.setText(questionslists.get(0).getOption3());
        option4.setText(questionslists.get(0).getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.round_back_red10);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionslists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.round_back_red10);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionslists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }


            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.round_back_red10);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionslists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.round_back_red10);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionslists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }


            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedOptionByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "please select an option", Toast.LENGTH_SHORT).show();
                } else {

                    changeNextQuestion();

                }
            }
        });



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void changeNextQuestion(){

        currentQuestionPosition++;

        if((currentQuestionPosition+1)== questionslists.size()){
            nextBtn.setText("Submit Quiz");
        }
        if(currentQuestionPosition<questionslists.size()){

            selectedOptionByUser="";

            option1.setBackgroundResource(R.drawable.round_back_white_stroke2_10xml);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_white_stroke2_10xml);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke2_10xml);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke2_10xml);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            questions.setText((currentQuestionPosition + 1) + "/" + questionslists.size());
            question.setText(questionslists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionslists.get(currentQuestionPosition).getOption1());
            option2.setText(questionslists.get(currentQuestionPosition).getOption2());
            option3.setText(questionslists.get(currentQuestionPosition).getOption3());
            option4.setText(questionslists.get(currentQuestionPosition).getOption4());

        }
        else {
            Intent intent = new Intent(QuizActivity.this,QuizResults.class);
            intent.putExtra("correct",getCorrectAnswers());
            intent.putExtra("incorrect",getInCorrectAnswers());
            startActivity(intent);

            finish();
        }
    }

    private void startTimer(TextView timerTextview) {

        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (seconds == 0  && totalTimeInMins >0) {
                    totalTimeInMins--;
                    seconds = 59;
                }
                else if (seconds == 0 && totalTimeInMins == 0) {

                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(QuizActivity.this, "Time Over", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(QuizActivity.this, QuizResults.class);
                    intent.putExtra("correct", getCorrectAnswers());
                    intent.putExtra("Incorrect", getInCorrectAnswers());
                    startActivity(intent);

                    finish();

                }
                else {
                    seconds--;

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String finalMinutes = String.valueOf((totalTimeInMins));
                        String finalSeconds = String.valueOf(seconds);

                        if (finalMinutes.length() == 1) {
                            finalMinutes = "0" + finalMinutes;
                        }
                        if (finalSeconds.length() == 1) {
                            finalSeconds = "0" + finalSeconds;
                        }

                        timerTextview.setText(finalMinutes + ":" + finalSeconds);
                    }
                });
            }
        }, 1000, 1000);
    }

    private int getCorrectAnswers() {

        int CorrectAnswers = 0;

        for (int i = 0; i < questionslists.size(); i++) {

            final String getUserSelectedAnswer = questionslists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionslists.get(i).getAnswer();

            if (getUserSelectedAnswer.equals(getAnswer)) {
                CorrectAnswers++;
            }
        }

        return CorrectAnswers;
    }

    private int getInCorrectAnswers() {

        int CorrectAnswers = 0;

        for (int i = 0; i < questionslists.size(); i++) {

            final String getUserSelectedAnswer = questionslists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionslists.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer)) {
                CorrectAnswers++;
            }
        }

        return CorrectAnswers;
    }

    @Override
    public void onBackPressed() {

        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();

    }

    private void revealAnswer() {

        final String getAnswer = questionslists.get(currentQuestionPosition).getAnswer();

        if (option1.getText().toString().equals(getAnswer)) {
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }
        else if (option2.getText().toString().equals(getAnswer)) {
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        }
        else if (option3.getText().toString().equals(getAnswer)) {
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        }
        else if (option4.getText().toString().equals(getAnswer)) {
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }
    }
}