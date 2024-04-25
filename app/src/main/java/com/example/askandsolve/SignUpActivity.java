package com.example.askandsolve;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.askandsolve.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import org.checkerframework.checker.nullness.qual.NonNull;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
//    FirebaseAuth auth;
//    FirebaseDatabase database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        LinearLayout linearLayout = findViewById(R.id.linearLayoutSignUp);

        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this,
                R.anim.from_right_left);

        linearLayout.startAnimation(slideFromRightAnimation);

//        auth = FirebaseAuth.getInstance();
//        database = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're Creating your account");



//        Using FireBase Database
//        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                progressDialog.show();
//
//                auth.createUserWithEmailAndPassword(binding.signUpEmail.getText().toString(),
//                        binding.signUpPassword.getText().toString()).
//                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if(task.isSuccessful()) {
//                                    progressDialog.dismiss();
//                                    String id = task.getResult().getUser().getUid();
//                                    User user = new User(binding.userName.getText().toString(),
//                                            binding.signUpEmail.getText().toString(),
//                                            binding.signUpPassword.getText().toString(), id);
//
//                                    database.getReference().child("Users").child(id).setValue(user);
//
//                                    Toast.makeText(SignUpActivity.this,
//                                            "User Created Successfully", Toast.LENGTH_SHORT);
//
//                                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
//                                } else {
//                                    Toast.makeText(SignUpActivity.this, task.getException().
//                                            getMessage(), Toast.LENGTH_SHORT);
//                                }
//                            }
//                        });
//
//            }
//        });

        binding.alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}

