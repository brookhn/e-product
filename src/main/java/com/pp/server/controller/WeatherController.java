package com.pp.server.controller;

import brave.propagation.ExtraFieldPropagation;
import com.pp.server.entity.WeatherResponse;
import com.pp.server.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    Logger log = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/shlo")
    public String helloSer()
    {
        String sessionId = ExtraFieldPropagation.get("SessionId");
        System.out.println(sessionId);
        return "hello,session is "+ ExtraFieldPropagation.get("SessionId");
    }

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getReportByCityId(@PathVariable("cityId") String cityId)
    {
        log.info("server receive param {}", cityId);
        return weatherService.getDataCityById(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getReportByCityName(@PathVariable("cityName") String cityName)
    {
        log.info("server receive param {}", cityName);
        return weatherService.getDataCityByName(cityName);
    }
}
