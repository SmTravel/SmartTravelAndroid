package com.smtravel.android.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.smtravel.android.MapsActivity;
import com.smtravel.android.R;
import com.smtravel.android.databinding.ActivityTravelBinding;

public class TravelActivity extends AppCompatActivity {
    private ActivityTravelBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTravelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void Maps(View view) {
        Intent intent= new Intent(TravelActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    public void goCities(View view){
        startActivity(new Intent(this,CitiesActivity.class));
    }
}
