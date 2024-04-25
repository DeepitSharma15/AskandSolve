package com.example.askandsolve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.askandsolve.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private ArrayList<Questions> questionList = new ArrayList<>();
    private static final String API_URL = "http://10.0.2.2:8000/questions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AskQuestion.class);
                startActivity(intent);
            }
        });
        binding.queList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnswerQuestion.class);
            }
        });

        getQuestions();




    }

    public void getQuestions() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, API_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Parse the JSONArray and create Question objects
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                int id = jsonObject.getInt("id");
                                String title = jsonObject.getString("title");
                                String ques_content = jsonObject.getString("ques_content");
                                Integer views = jsonObject.getInt("views");
                                boolean is_answered = jsonObject.getBoolean("is_answered");
                                Integer votes = jsonObject.getInt("votes");
                                boolean has_acceptable_answer = jsonObject.getBoolean("has_acceptable_answer");
                                Integer user_id = jsonObject.getInt("user_id");

                                // Create a Question object and add it to the ArrayList
                                Questions question = new Questions(id, views,votes,title,ques_content,
                                is_answered,has_acceptable_answer,user_id);
                                questionList.add(question);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        // Display or use the ArrayList data as needed
                        // For example, you can log the elements in the ArrayList
                        binding.queList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        QuestionsAdapter adapter = new QuestionsAdapter(questionList, MainActivity.this);
                        binding.queList.setAdapter(adapter);
                        for (Questions question : questionList) {
                            Log.e("MainActivity", "Question: " + question.getTitle());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error in fetching JSON data
                Log.e("MainActivity", "Error: " + error.toString());
            }
        });

        // Add the JSON request to the RequestQueue
        queue.add(jsonArrayRequest);


    }


}