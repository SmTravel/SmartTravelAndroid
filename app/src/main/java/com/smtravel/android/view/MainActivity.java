package com.smtravel.android.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.smtravel.android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }, 5000);
    }
}
