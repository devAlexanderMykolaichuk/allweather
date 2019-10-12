package allweather.gateways.openweather.protocol;

import com.google.api.client.util.Key;
import lombok.Data;

@Data
public class OpenWeatherClouds {
    @Key
    private int all;
}
