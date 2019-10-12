package allweather.gateways.openweather.protocol;

import com.google.api.client.util.Key;
import lombok.Data;

@Data
public class OpenWeatherWeather {
    @Key
    private int id;
    @Key
    private String main;
    @Key
    private String description;
    @Key
    private String icon;
}
