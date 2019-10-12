package allweather.gateways.openweather.protocol;

import com.google.api.client.util.Key;
import lombok.Data;

@Data
public class OpenWeatherMain {
    @Key
    private int pressure;
    @Key
    private int humidity;
    @Key
    private double temp;
    @Key
    private double temp_min;
    @Key
    private double temp_max;
}
