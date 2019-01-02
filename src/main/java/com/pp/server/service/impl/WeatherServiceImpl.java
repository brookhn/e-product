package com.pp.server.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pp.server.entity.WeatherResponse;
import com.pp.server.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final  Long TIME_OUT = 1800L;

//    @Autowired
//    private RedisTemplate redisTemplate;

    @Autowired
    private RestTemplate restTemplate;

    private final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini";

    @Override
    public WeatherResponse getDataCityById(String cityId) {
        String uri = WEATHER_URL+"?citykey="+ cityId;
        return this.doGetWeatherData(uri);
    }

    @Override
    public WeatherResponse getDataCityByName(String name) {
        String url = WEATHER_URL + "?city="+name;
        return this.doGetWeatherData(url);
    }

    private WeatherResponse doGetWeatherData(String url)
    {
        //restTemplate请求
        //ValueOperations<String,String> ops = this.redisTemplate.opsForValue();
        String key = url;
        String strBody = null;
        WeatherResponse weatherResponse = null;
//        if (!this.redisTemplate.hasKey(key)) {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCodeValue() == 200) {
                strBody = response.getBody();
            }
//            ops.set(key, strBody, TIME_OUT,TimeUnit.SECONDS);
//        }else {
//            strBody = ops.get(key);
//        }
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            weatherResponse = objectMapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }
}
