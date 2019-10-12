package allweather.gateways.openweather.protocol;

import com.google.api.client.util.Key;
import lombok.Data;

import java.util.List;

@Data
public class OpenWeatherResponse {

    @Key
    private int cod;
    @Key
    private String name;
    @Key
    private Long id;
    @Key
    private int timeZone;
    @Key
    private OpenWeatherSys sys;
    @Key
    private Long dt;
    @Key
    private OpenWeatherClouds clouds;
    @Key
    private OpenWeatherWind wind;
    @Key
    private int visibility;
    @Key
    private OpenWeatherMain main;
    @Key
    private String base;
    @Key
    private List<OpenWeatherWeather> weather;
    @Key
    private OpenWeatherCoordinate coord;
}
