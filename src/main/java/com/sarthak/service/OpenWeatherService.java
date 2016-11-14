package com.sarthak.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarthak.DTO.CurrentDataDTO;
import com.sarthak.client.OpenWeatherClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Sarthak on 14-11-2016.
 */
@Service
public class OpenWeatherService {
    private OpenWeatherClient openWeatherClient;
    public CurrentDataDTO getTemperatureAndWeather(String cityName){
        String data = openWeatherClient.getCurrentWeatherData(cityName);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode weatherData=null;
        try {
            weatherData = objectMapper.readTree(data);
        }
        catch (IOException exception){
            exception.printStackTrace();
        }

        JsonNode main=weatherData.get("main");
        double temperatureInKelvin = main.get("temp").doubleValue();
        double temperatureInCelsius = temperatureInKelvin-273.15;
        double humidityInPercent = main.get("humidity").doubleValue();
        JsonNode weather=weatherData.get("weather").get(0);
        String skyCondition=weather.get("description").textValue();

        return new CurrentDataDTO(temperatureInCelsius,skyCondition,humidityInPercent);
    }
}
