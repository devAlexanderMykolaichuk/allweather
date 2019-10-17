package allweather.gateways.openweather;



import allweather.gateways.openweather.protocol.OpenWeatherResponse;
import allweather.service.OpenWeatherCityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Log4j2
@Service
public class OpenWeatherClient extends AbstractClient{

    private static final String BASE_URL_CURRENT = "https://api.openweathermap.org/data/2.5/weather";
    private static final String BASE_URL_FORECAST = "https:api.openweathermap.org/data/2.5/forecast";
    private static final String APPID = "appid=c7defecbfa765360affb39c837caac74";

    private final OpenWeatherCityService openWeatherCityService;

    public OpenWeatherClient(OpenWeatherCityService openWeatherCityService) {
        this.openWeatherCityService = openWeatherCityService;
    }


    public OpenWeatherResponse getCurrentWeather() throws IOException {
        Long cityId = openWeatherCityService.getCityIdByName("Kiev");
        return get(getUrl(cityId, BASE_URL_CURRENT), OpenWeatherResponse.class);
    }

    public String getForecastWeather() throws IOException {
        Long cityId = openWeatherCityService.getCityIdByName("Kiev");
        return get(getUrl(cityId, BASE_URL_FORECAST));
    }

    private String getUrl(Long cityId, String baseUrl){
        //todo: refactor
        String url = baseUrl
                +"?id="+cityId.toString()
                +"&"+APPID
                +"&"+"units=metric";
        log.info("URL for request was build: "+ url);
        return url;
    }

}
