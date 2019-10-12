package allweather.gateways.openweather;



import allweather.gateways.openweather.protocol.OpenWeatherResponse;
import allweather.service.OpenWeatherCityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Log4j2
@Service
public class OpenWeatherClient extends AbstractClient{

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String APPID = "appid=c7defecbfa765360affb39c837caac74";

    @Autowired
    private OpenWeatherCityService openWeatherCityService;


    //todo: NEED TO FIGURED OUT HOW TO HANDLE REQUEST
    public OpenWeatherResponse getTest() throws IOException {
        return get(getUrl(openWeatherCityService.getCityByName("Kiev").getId()), OpenWeatherResponse.class);
    }

    private String getUrl(Long cityId){
        //todo: refactor
        String url = BASE_URL+"?"+"id="+cityId.toString()+"&"+APPID+"&"+"units=metric";
        log.info("URL for request was build: "+ url);
        return url;
    }

}
