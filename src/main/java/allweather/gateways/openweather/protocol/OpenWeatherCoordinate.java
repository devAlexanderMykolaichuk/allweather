package allweather.gateways.openweather.protocol;

import com.google.api.client.util.Key;
import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class OpenWeatherCoordinate {

    @Key
    private double lon;

    @Key
    private double lat;
}
