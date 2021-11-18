package com.smtravel.android.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.smtravel.android.databinding.ActivityCitiesBinding;
import com.smtravel.android.model.CityModel;
import com.smtravel.android.viewmodel.CityListAdapter;
import com.smtravel.android.viewmodel.ListViewModel;

import java.util.ArrayList;
import java.util.List;

public class CitiesActivity extends AppCompatActivity {
    private ActivityCitiesBinding binding;
    private ListViewModel listViewModel;
    private CityListAdapter adapter = new CityListAdapter(new ArrayList<>());
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCitiesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        listViewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        listViewModel.refresh();
        binding.citiesList.setLayoutManager(new LinearLayoutManager(this));
        binding.citiesList.setAdapter(adapter);
        binding.refreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listViewModel.refresh();
                binding.refreshView.setRefreshing(false);
            }
        });
        observeViewModel();
    }
    private void observeViewModel(){
        listViewModel.cities.observe(this, new Observer<List<CityModel>>() {
            @Override
            public void onChanged(List<CityModel> cityModels) {
                binding.citiesList.setVisibility(View.VISIBLE);
                adapter.updateCities(cityModels);
            }
        });
    }
}
