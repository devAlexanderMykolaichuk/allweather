package allweather.gateways.openweather;



import allweather.gateways.openweather.protocol.OpenWeatherResponse;
import allweather.service.OpenWeatherCityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Log4j2
@Service
public class OpenWeatherClient extends AbstractClient{

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String APPID = "appid=c7defecbfa765360affb39c837caac74";

    private final OpenWeatherCityService openWeatherCityService;

    public OpenWeatherClient(OpenWeatherCityService openWeatherCityService) {
        this.openWeatherCityService = openWeatherCityService;
    }


    public OpenWeatherResponse getCurrentWeather() throws IOException {
        Long cityId = openWeatherCityService.getCityIdByName("Kiev");
        return get(getUrl(cityId), OpenWeatherResponse.class);
    }

    private String getUrl(Long cityId){
        //todo: refactor
        String url = BASE_URL
                +"?id="+cityId.toString()
                +"&"+APPID
                +"&"+"units=metric";
        log.info("URL for request was build: "+ url);
        return url;
    }

}
