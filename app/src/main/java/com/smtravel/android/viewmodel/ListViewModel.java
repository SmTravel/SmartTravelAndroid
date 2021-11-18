package com.smtravel.android.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.smtravel.android.model.CitiesService;
import com.smtravel.android.model.CityModel;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends ViewModel {
    public MutableLiveData<List<CityModel>> cities = new MutableLiveData<>();
    private CitiesService citiesService = CitiesService.getInstance();
    private CompositeDisposable disposable = new CompositeDisposable();

    public void refresh() {
        fetchCountries();
    }

    private void fetchCountries() {
        disposable.add(
                citiesService.getCities()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<CityModel>>() {
                    @Override
                    public void onSuccess(List<CityModel> cityModels) {
                        cities.setValue(cityModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
