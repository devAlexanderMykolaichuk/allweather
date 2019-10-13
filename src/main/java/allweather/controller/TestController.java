package allweather.controller;

import allweather.entity.openweather.OpenWeatherCity;
import allweather.gateways.openweather.OpenWeatherClient;
import allweather.repository.OpenWeatherCityRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {


    private final OpenWeatherCityRepository openWeatherCityRepository;

    private final OpenWeatherClient openWeatherClient;

    public TestController(OpenWeatherCityRepository openWeatherCityRepository, OpenWeatherClient openWeatherClient) {
        this.openWeatherCityRepository = openWeatherCityRepository;
        this.openWeatherClient = openWeatherClient;
    }

    @GetMapping("/token")
    public String getTest(){
        return SecurityContextHolder.getContext().getAuthentication().toString();
    }

    @GetMapping("/test")
    public String getTestOW() throws IOException {
        return openWeatherClient.getCurrentWeather().toString();
    }


    @PostMapping("/addCity")
    public String addCity(@RequestBody List<OpenWeatherCity> openWeatherCities){
        openWeatherCityRepository.saveAll(openWeatherCities);
        return "yep";
    }
}
