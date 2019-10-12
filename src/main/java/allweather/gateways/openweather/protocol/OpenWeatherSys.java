package allweather.gateways.openweather.protocol;

import com.google.api.client.util.Key;
import lombok.Data;

@Data
public class OpenWeatherSys {
    @Key
    private int type;
    @Key
    private int id;
    @Key
    private double message;
    @Key
    private String country;
    @Key
    private Long sunrise;
    @Key
    private Long sunset;
}
