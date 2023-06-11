package com.example.pepcorn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pepcorn.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(this, MainActivity.class));
            finishAffinity();
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        // hide the keyboard after touching outside
        binding.getRoot().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if(view != null){
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        return true;
                }
                return false;
            }
        });

        binding.registerBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, SignUpActivity.class));
            overridePendingTransition(0,0);
            finishAffinity();
        });

        binding.login.setOnClickListener(v -> {

            if(!binding.email.getText().toString().trim().equals("") && !binding.password.getText().toString().trim().equals("") ){

                if(!Patterns.EMAIL_ADDRESS.matcher(binding.email.getText().toString().trim()).matches()){
                    Toast.makeText(this, "Please enter email in correct pattern", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Login

                mAuth.signInWithEmailAndPassword(binding.email.getText().toString().trim(), binding.password.getText().toString().trim())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finishAffinity();
                                }
                                else
                                    Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

            }
            else Toast.makeText(this, "Please enter * fields", Toast.LENGTH_SHORT).show();

        });
    }
}