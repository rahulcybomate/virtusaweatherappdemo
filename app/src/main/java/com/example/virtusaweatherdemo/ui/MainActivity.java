package com.example.virtusaweatherdemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.virtusaweatherdemo.R;
import com.example.virtusaweatherdemo.databinding.ActivityMainBinding;
import com.example.virtusaweatherdemo.models.WeatherDataResponse;
import com.example.virtusaweatherdemo.viewModels.WeatherViewModel;


public class MainActivity extends AppCompatActivity {
    String cityName="raipur";
    WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding mainXml = DataBindingUtil.setContentView(this, R.layout.activity_main);
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        weatherViewModel.getData(cityName);

        weatherViewModel.weatherDataResponseMutableLiveData.observe(this, new Observer<WeatherDataResponse>() {
            @Override
            public void onChanged(WeatherDataResponse s) {
                mainXml.temp.setText(String.valueOf(s.getMain().getTemp()));
                mainXml.humidity.setText(String.valueOf(s.getMain().getHumidity()));
                mainXml.minTemp.setText(String.valueOf(s.getMain().getTemp_min()));
                mainXml.maxTemp.setText(String.valueOf(s.getMain().getTemp_max()));
            }
        });


       mainXml.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchCity( mainXml.city.getText().toString());
           }
        });
    }

    public void searchCity(String cityString){
        if(cityString.equals("")){
            Toast.makeText(this, "Please Enter City Name", Toast.LENGTH_SHORT).show();
            return;
        }
        weatherViewModel.getData(cityString);
    }
}