package com.example.cookiequiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Objects;

public class QuizResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_quiz_results);

        final AppCompatButton menuBtn = findViewById(R.id.actQuizResults_menuBtn);
        final TextView correctAnswer = findViewById(R.id.actQuizResult_Text);
        final TextView wonCookies = findViewById(R.id.actQuizResult_WonCookies);

        final int getCorrectAnswers = getIntent().getIntExtra("correct", 0);

        String correctAnswerString = "You answered " + String.valueOf(getCorrectAnswers) +"\nquestions correctly.";
        String wonCookiesString = String.valueOf(getCorrectAnswers*10) +" Cookies";

        correctAnswer.setText(correctAnswerString);
        wonCookies.setText(wonCookiesString);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizResults.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResults.this, MainActivity.class));
        finish();
    }
}