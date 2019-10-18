package allweather.gateways.openweather.protocol;

import com.google.api.client.util.Key;
import lombok.Data;

import java.util.List;

@Data
public class OpenWeatherForecast {

    @Key
    private Long dt;
    @Key
    private OpenWeatherMain main;
    @Key
    private List<OpenWeatherWeather> weather;
    @Key
    private OpenWeatherClouds clouds;
    @Key
    private OpenWeatherWind wind;
    @Key
    private OpenWeatherSys sys;

}
