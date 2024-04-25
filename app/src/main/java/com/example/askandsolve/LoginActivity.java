package com.example.askandsolve;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.askandsolve.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class LoginActivity extends AppCompatActivity {
    private ApiService apiService;
    ActivityLoginBinding binding;
    ProgressDialog progressDialog;
    //FirebaseAuth auth;
    //private static final String LOGIN_URL = "http://10.0.2.2:8000/login";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize Retrofit
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(LOGIN_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        apiService = retrofit.create(ApiService.class);

        getSupportActionBar().hide();

        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this,
                R.anim.from_right_left);
        binding.linearLayout.startAnimation(slideFromRightAnimation);

        //auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("Log In");
        progressDialog.setMessage("Login to your account");


//      Login Using Firebase
//        binding.loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                progressDialog.show();
//                auth.signInWithEmailAndPassword(binding.loginEmailId.getText().toString(),
//                        binding.loginPassword.getText().toString()).
//                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        progressDialog.dismiss();
//                        if(task.isSuccessful()) {
//
//                            Intent intent = new Intent(LoginActivity.this,
//                                    MainActivity.class);
//                            startActivity(intent);
//                        }
//
//                        else {
//                            Toast.makeText(LoginActivity.this, task.getException().getMessage(),
//                                    Toast.LENGTH_SHORT);
//                        }
//                    }
//                });
//
//            }
//        });
//        if(auth.getCurrentUser() != null) {
//            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }


        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                String email = binding.loginEmailId.getText().toString();
                String password = binding.loginPassword.getText().toString();

                Gson gson = new GsonBuilder().create();
                MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                RequestBody requestBody = RequestBody.create(JSON, gson.toJson(new User(email, password)));




                //loginUser(email , password);

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);


            }
        });

        binding.textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

//    private void loginUser(final String username, final String password) {
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            String accessToken = jsonObject.getString("access_token");
//                            // Save/access token for future API requests
//                            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // Handle error in login request
//                        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
//                        Log.e("LoginActivity", "Error: " + error.toString());
//                    }
//                }) {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<>();
//                params.put("username", username);
//                params.put("password", password);
//                return params;
//            }
//        };
//
//        // Add the request to the RequestQueue
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }
}
