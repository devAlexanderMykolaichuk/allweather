package allweather.gateways.openweather.protocol;

import lombok.Data;

import java.util.List;

@Data
public class OpenWeatherEsObject {

    private Long dt;

    private Long requestTime;

    private String cityName;

    private Long cityId;

    private OpenWeatherMain main;

    private List<OpenWeatherWeather> weather;

    private OpenWeatherClouds clouds;

    private OpenWeatherWind wind;

    private OpenWeatherSys sys;

    private OpenWeatherCoordinate coord;

    private List<OpenWeatherForecast> forecasts;


}
