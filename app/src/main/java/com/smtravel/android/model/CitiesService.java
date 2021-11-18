package com.smtravel.android.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CitiesService {
    private static final String BASE_URL = "https://gist.githubusercontent.com";

    private static CitiesService instance;

    private CitiesService(){}

    private CitiesAPI api = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CitiesAPI.class);

    public static CitiesService getInstance(){
        if (instance == null)
            instance = new CitiesService();
        return instance;
    }

    public Single<List<CityModel>> getCities(){
        return api.getCities();
    }

}
