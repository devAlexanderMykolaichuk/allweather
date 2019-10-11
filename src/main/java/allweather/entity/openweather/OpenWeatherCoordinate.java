package allweather.entity.openweather;

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class OpenWeatherCoordinate {

    private double lon;

    private double lat;
}
