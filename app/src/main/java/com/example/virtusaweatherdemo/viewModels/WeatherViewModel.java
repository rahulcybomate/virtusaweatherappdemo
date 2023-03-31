package com.example.virtusaweatherdemo.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.virtusaweatherdemo.apis.RetrofitClient;
import com.example.virtusaweatherdemo.models.WeatherDataResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends ViewModel {
    public MutableLiveData<WeatherDataResponse> weatherDataResponseMutableLiveData = new MutableLiveData<>();
    public void getData(String cityName){
        Call<WeatherDataResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .get_weather_data(cityName,"bf135504707cc22f704a3587fbbf3db1");
        call.enqueue(new Callback<WeatherDataResponse>() {
            @Override
            public void onResponse(Call<WeatherDataResponse> call, Response<WeatherDataResponse> response) {
                weatherDataResponseMutableLiveData.setValue(response.body());
            }
            @Override
            public void onFailure(Call<WeatherDataResponse> call, Throwable t) {

            }
        });
    }
}
