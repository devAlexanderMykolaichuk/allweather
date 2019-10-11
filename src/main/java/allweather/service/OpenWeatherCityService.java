package allweather.service;

import allweather.entity.openweather.OpenWeatherCity;

public interface OpenWeatherCityService {

    OpenWeatherCity getCityByName(String name);
}
