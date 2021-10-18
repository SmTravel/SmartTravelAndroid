package com.smtravel.android.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.smtravel.android.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initFirebaseAuth();
        setClickForView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getCurrentUser();
    }

    private void setClickForView(){
        binding.loginSignIn.setOnClickListener(view -> {
            String email = binding.signInEmail.getText().toString();
            String password = binding.signInPassword.getText().toString();
            if (email.matches("") && password.matches("")){
                Toast.makeText(LoginActivity.this,"Email or Password is Wrong",Toast.LENGTH_LONG).show();
            }else{
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d("SignIn","signInWithEmail:success");
                            FirebaseUser user = auth.getCurrentUser();
                            startActivity(new Intent(LoginActivity.this, TravelActivity.class));
                            finish();
                        }else{
                            Log.w("SignIn","signInWithEmail:failure",task.getException());
                            Toast.makeText(LoginActivity.this,"Authentication Failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    private void getCurrentUser(){
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null){
            startActivity(new Intent(LoginActivity.this,MainscreenActivity.class));
            finish();
        }
    }

    private void initFirebaseAuth(){
        auth = FirebaseAuth.getInstance();
    }


    public void createAccount(View view) {
        Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(intent);
    }

}
