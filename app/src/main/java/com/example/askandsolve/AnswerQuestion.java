package com.example.askandsolve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.askandsolve.databinding.ActivityAnswerQuestionBinding;
import com.example.askandsolve.databinding.ActivityMainBinding;

public class AnswerQuestion extends AppCompatActivity {
    ActivityAnswerQuestionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_question);

        binding = ActivityAnswerQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        String title = getIntent().getStringExtra("Title");
        String queContent = getIntent().getStringExtra("Question_Content");

        binding.questionTitle.setText(title);
        binding.totalAnswer.setText(queContent);
    }
}