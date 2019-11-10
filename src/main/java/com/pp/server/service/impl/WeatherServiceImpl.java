package com.pp.server.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pp.server.common.Constats;
import com.pp.server.common.DateUtil;
import com.pp.server.entity.WeatherResponse;
import com.pp.server.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final  Long TIME_OUT = 1800L;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RestTemplate restTemplate;

    private final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini";

    @Override
    public WeatherResponse getDataCityById(String cityId) {
        String uri = WEATHER_URL+"?citykey="+ cityId;
        String redisKey = Constats.REDIS_WEATHER_CITY_NAME_KEY+":"+cityId+ DateUtil.getFormatDateTime(new Date(),DateUtil.DATE_TIME_NUM);
        return this.doGetWeatherData(uri, cityId);
    }

    @Override
    public WeatherResponse getDataCityByName(String name) {
        String url = WEATHER_URL + "?city="+name;
        String redisKey = Constats.REDIS_WEATHER_CITY_NAME_KEY+":"+name+ DateUtil.getFormatDateTime(new Date(),DateUtil.DATE_NUM);
        return this.doGetWeatherData(url, redisKey);
    }

    private WeatherResponse doGetWeatherData(String url, String redisKey)
    {
        //restTemplate请求
        ValueOperations<String,String> ops = this.redisTemplate.opsForValue();
        String strBody = null;
        WeatherResponse weatherResponse = null;
        if (!this.redisTemplate.hasKey(redisKey)) {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCodeValue() == 200) {
                strBody = response.getBody();
            }
            ops.set(redisKey, strBody, TIME_OUT,TimeUnit.SECONDS);
        }else {
            strBody = ops.get(redisKey);
        }
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            weatherResponse = objectMapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }
}
