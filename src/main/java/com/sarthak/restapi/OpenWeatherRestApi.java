package com.sarthak.restapi;

import com.sarthak.DTO.CurrentDataDTO;
import com.sarthak.service.OpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sarthak on 14-11-2016.
 */
@RestController
public class OpenWeatherRestApi {
    private OpenWeatherService openWeatherService;

    @Autowired
    public void setOpenWeatherService(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }
    @CrossOrigin
    @RequestMapping(value = "/getCurrentWeatherData/{cityName}")
    public CurrentDataDTO getCurrentWeatherData(@PathVariable String cityName){
        CurrentDataDTO currentDataDTO=openWeatherService.getWeatherData(cityName);
        return currentDataDTO;
    }
}
