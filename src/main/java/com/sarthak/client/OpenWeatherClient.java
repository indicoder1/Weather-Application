package com.sarthak.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Sarthak on 14-11-2016.
 */
@Component
public class OpenWeatherClient {
    public String getCurrentWeatherData(String cityName){
        RestTemplate restTemplate=new RestTemplate();
        String queryUrl="http://api.openweathermap.org/data/2.5/weather?q=cityname&appid=ebe5a29553710694961b13f338f2358a";
        queryUrl=queryUrl.replaceAll("cityname",cityName);
        String weatherData=restTemplate.getForObject(queryUrl,String.class);
        return weatherData;
    }
}
