package allweather.gateways.openweather.protocol;

import com.google.api.client.util.Key;
import lombok.Data;

@Data
public class OpenWeatherWind {

    @Key
    private int speed;

    @Key
    private int deg;
}
