package allweather.service.impl;

import allweather.entity.openweather.OpenWeatherCity;
import allweather.repository.OpenWeatherCityRepository;
import allweather.service.OpenWeatherCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherCityServiceImpl implements OpenWeatherCityService {

    @Autowired
    private OpenWeatherCityRepository openWeatherCityRepository;

    @Override
    public OpenWeatherCity getCityByName(String name) {
        return openWeatherCityRepository.findByName(name);
    }

}
