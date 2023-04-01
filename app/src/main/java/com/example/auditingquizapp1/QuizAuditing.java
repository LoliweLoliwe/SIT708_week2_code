package com.example.auditingquizapp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Random;
import android.widget.Toast;

public class QuizAuditing extends AppCompatActivity {

    TextView label, question, progValue;
    Button opt1Button, opt2Button, opt3Button;
    Button nextBtn, backBtn;
    private String mLabels;
    private String mAnswer;
    int yourScore, currentProgress;
    Integer mQuestionsLength = QuizTest.mQuestions.length;
    private ProgressBar progressBar;
    private Handler handler = new Handler();

    String selectedAnswer = "";
    String receivedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_auditing);

        try {

            label = findViewById(R.id.textView4);
            question = findViewById(R.id.textView3);
            opt1Button = findViewById(R.id.btn2);
            opt2Button = findViewById(R.id.btn3);
            opt3Button = findViewById(R.id.btn4);
            backBtn = findViewById(R.id.bckButton5);
            nextBtn = findViewById(R.id.nxButton6);

            Intent valueIntent = getIntent();
            receivedValue = valueIntent.getStringExtra("VALUE_KEY");

            Intent xIntent = getIntent();
            Bundle bundle = xIntent.getExtras();
            int ourScore = bundle.getInt("NIL_KEY");
            currentProgress = bundle.getInt("TER_KEY");

            progressBar = findViewById(R.id.progressB);
            progValue = findViewById(R.id.textView7);

            loadNewQuestion();

            opt1Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedAnswer = opt1Button.getText().toString();

                    if (selectedAnswer.equals(QuizTest.mCorrectAnswers[currentProgress])) {
                        yourScore++;
                    }

                    opt1Button.setBackgroundColor(Color.WHITE);
                    opt1Button.setTextColor(Color.BLACK);
                    currentProgress++;
                    opt2Button.setEnabled(false);
                    opt3Button.setEnabled(false);
                }
            });

            opt2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedAnswer = opt2Button.getText().toString();
                    if (selectedAnswer.equals(QuizTest.mCorrectAnswers[currentProgress])) {
                        yourScore++;
                    }

                    opt2Button.setBackgroundColor(Color.WHITE);
                    opt2Button.setTextColor(Color.BLACK);
                    opt1Button.setEnabled(false);
                    opt3Button.setEnabled(false);
                    currentProgress++;
                }
            });

            opt3Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedAnswer = opt3Button.getText().toString();
                    if(selectedAnswer.equals(QuizTest.mCorrectAnswers[currentProgress])) {
                        yourScore++;
                    }

                    opt3Button.setBackgroundColor(Color.WHITE);
                    opt3Button.setTextColor(Color.BLACK);
                    opt1Button.setEnabled(false);
                    opt2Button.setEnabled(false);
                    currentProgress++;
                }
            });

            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent newIntent = new Intent(QuizAuditing.this, MainActivity.class);
                    startActivity(newIntent);
                }
            });

            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(QuizAuditing.this, "Score: " + currentProgress, Toast.LENGTH_SHORT).show();

                    loadNewQuestion();
                    opt1Button.setBackgroundColor(Color.rgb(80,20,221));
                    opt2Button.setBackgroundColor(Color.rgb(80,20,221));
                    opt3Button.setBackgroundColor(Color.rgb(80,20,221));
                    opt1Button.setTextColor(Color.WHITE);
                    opt2Button.setTextColor(Color.WHITE);
                    opt3Button.setTextColor(Color.WHITE);
                }
            });

        }
        catch (Exception e){
            Toast.makeText(QuizAuditing.this, "Something was not done right", Toast.LENGTH_SHORT).show();
        }
    }

    void loadNewQuestion() {
        if (currentProgress == mQuestionsLength) {
            Bundle bundle = new Bundle();
            bundle.putString("VALUE_KEY", receivedValue);
            bundle.putInt("SCORE_KEY", yourScore);
            Intent newIntent = new Intent(this, LastPage.class);
            newIntent.putExtras(bundle);
            startActivity(newIntent);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(currentProgress);
                        progValue.setText(currentProgress+"/"+progressBar.getMax());
                    }
                });
            }
        }).start();

        if (currentProgress < mQuestionsLength) {
            opt1Button.setEnabled(true);
            opt2Button.setEnabled(true);
            opt3Button.setEnabled(true);
            label.setText(QuizTest.mLabels[currentProgress]);
            question.setText(QuizTest.mQuestions[currentProgress]);
            opt1Button.setText(QuizTest.mAnswers[currentProgress][0]);
            opt2Button.setText(QuizTest.mAnswers[currentProgress][1]);
            opt3Button.setText(QuizTest.mAnswers[currentProgress][2]);
        }
    }
}