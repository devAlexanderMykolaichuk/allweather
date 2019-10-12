package allweather.controller;

import allweather.entity.openweather.OpenWeatherCity;
import allweather.gateways.openweather.OpenWeatherClient;
import allweather.repository.OpenWeatherCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private OpenWeatherCityRepository openWeatherCityRepository;

    @Autowired
    private OpenWeatherClient openWeatherClient;

    @GetMapping("/token")
    public String getTest(){
        return SecurityContextHolder.getContext().getAuthentication().toString();
    }

    @GetMapping("/test")
    public String getTestOW() throws IOException {
        return openWeatherClient.getTest().toString();
    }


    @PostMapping("/addCity")
    public String addCity(@RequestBody List<OpenWeatherCity> openWeatherCities){
        openWeatherCityRepository.saveAll(openWeatherCities);
        return "yep";
    }
}
