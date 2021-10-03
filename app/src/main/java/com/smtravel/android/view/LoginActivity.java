package com.smtravel.android.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.smtravel.android.R;

public class LoginActivity extends AppCompatActivity {
    private TextView createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    private void getControlView(){
        createAccount = (TextView) findViewById(R.id.createAccount);
    }

    private void setClickForView(){

    }


    public void createAccount(View view) {
        Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(intent);
    }

}
