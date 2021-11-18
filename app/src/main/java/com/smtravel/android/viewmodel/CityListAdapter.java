package com.smtravel.android.viewmodel;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smtravel.android.R;
import com.smtravel.android.databinding.CitiesRowBinding;
import com.smtravel.android.model.CityModel;

import java.util.List;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.CityViewHolder>{

    private CitiesRowBinding binding;
    private List<CityModel> cities;

    public CityListAdapter(List<CityModel> cities) {
        this.cities = cities;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateCities(List<CityModel> newCities){
        cities.clear();
        cities.addAll(newCities);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CitiesRowBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new CityViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.binding.cityIDText.setText(cities.get(position).getID());
        holder.binding.cityNameText.setText(cities.get(position).getName());
        holder.binding.cityPopulationText.setText(cities.get(position).getPopulation());
        holder.binding.cityRegionText.setText(cities.get(position).getRegion());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder{
        CitiesRowBinding binding;
        public CityViewHolder(@NonNull CitiesRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
