package com.sarthak.DTO;

/**
 * Created by Sarthak on 14-11-2016.
 */
public class CurrentDataDTO {
    private double temperature;
    private String skyCondition;
    private double humidityInPercent;
    private String cityName;
    public CurrentDataDTO(double temperature, String skyCondition, double humidityInPercent, String cityName) {
        this.temperature = temperature;
        this.skyCondition = skyCondition;
        this.humidityInPercent = humidityInPercent;
        this.cityName = cityName;
    }

    public double getHumidityInPercent() {
        return humidityInPercent;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getSkyCondition() {
        return skyCondition;
    }

    public String getCityName() {
        return cityName;
    }
}
