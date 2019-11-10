package com.pp.server.service;


import com.pp.server.entity.WeatherResponse;

public interface WeatherService {

    WeatherResponse getDataCityById(String cityId);


    WeatherResponse getDataCityByName(String name);
}
