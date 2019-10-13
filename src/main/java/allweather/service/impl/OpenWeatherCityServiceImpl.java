package allweather.service.impl;

import allweather.repository.OpenWeatherCityRepository;
import allweather.service.OpenWeatherCityService;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherCityServiceImpl implements OpenWeatherCityService {

    private final OpenWeatherCityRepository openWeatherCityRepository;

    public OpenWeatherCityServiceImpl(OpenWeatherCityRepository openWeatherCityRepository) {
        this.openWeatherCityRepository = openWeatherCityRepository;
    }

    @Override
    public Long getCityIdByName(String name) {
        return openWeatherCityRepository.findIdByName(name);
    }

}
