package allweather.controller;

import allweather.entity.openweather.OpenWeatherCity;
import allweather.gateways.elasticsearch.ESClient;
import allweather.gateways.elasticsearch.IndexBuilder;
import allweather.gateways.openweather.OpenWeatherClient;
import allweather.gateways.openweather.protocol.OpenWeatherResponse;
import allweather.repository.OpenWeatherCityRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {


    private final OpenWeatherCityRepository openWeatherCityRepository;

    private final OpenWeatherClient openWeatherClient;

    @Autowired
    private ESClient esClient;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    IndexBuilder indexBuilder;

    public TestController(OpenWeatherCityRepository openWeatherCityRepository, OpenWeatherClient openWeatherClient) {
        this.openWeatherCityRepository = openWeatherCityRepository;
        this.openWeatherClient = openWeatherClient;
    }

    @GetMapping("/token")
    public String getTest(){
        return SecurityContextHolder.getContext().getAuthentication().toString();
    }

    @GetMapping("/test")
    public void getTestOW() throws IOException {
        //OpenWeatherResponse openWeatherResponse = openWeatherClient.getCurrentWeather();
        //System.out.println("response is " + openWeatherResponse.toString());
        esClient.getIndex();

    }


    @PostMapping("/addCity")
    public String addCity(@RequestBody List<OpenWeatherCity> openWeatherCities){
        openWeatherCityRepository.saveAll(openWeatherCities);
        return "yep";
    }
}
