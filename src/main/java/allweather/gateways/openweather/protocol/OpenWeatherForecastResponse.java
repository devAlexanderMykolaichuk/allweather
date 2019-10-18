package allweather.gateways.openweather.protocol;

import com.google.api.client.util.Key;
import lombok.Data;

import java.util.List;

@Data
public class OpenWeatherForecastResponse {

    @Key
    private int cod;
    @Key
    private int message;
    @Key
    private int cnt;
    @Key
    private List<OpenWeatherForecast> list;
}
