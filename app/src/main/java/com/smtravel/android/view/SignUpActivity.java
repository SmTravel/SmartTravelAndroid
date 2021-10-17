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
import com.smtravel.android.R;
import com.smtravel.android.databinding.ActivitySignupBinding;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private ActivitySignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initFirebaseAuth();
        setClickForView();
    }

    private void setClickForView(){
        binding.signUpCreateAccount.setOnClickListener(view -> {
            String signUpEmail = binding.signUpEmail.getText().toString();
            String signUpPassword = binding.signUpPassword.getText().toString();
            auth.createUserWithEmailAndPassword(signUpEmail,signUpPassword).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Log.d("SignUp","createUserWithEmail:Success");
                        FirebaseUser user = auth.getCurrentUser();
                        startActivity(new Intent(SignUpActivity.this,MainscreenActivity.class));
                        finish();
                    }else{
                        Log.w("SignUp","createUserWithEmail:failure", task.getException());
                        Toast.makeText(SignUpActivity.this, task.getException().getMessage().matches("") ? "Authentication Failed":task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        });
    }

    private void initFirebaseAuth(){
        auth = FirebaseAuth.getInstance();
    }

    public void SignIn(View view) {
        onBackPressed();
    }
}
