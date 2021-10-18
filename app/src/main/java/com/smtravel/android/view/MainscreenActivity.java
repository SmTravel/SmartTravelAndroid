package com.smtravel.android.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.smtravel.android.databinding.ActivityMainscreenBinding;

public class MainscreenActivity extends AppCompatActivity {
    private ActivityMainscreenBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
