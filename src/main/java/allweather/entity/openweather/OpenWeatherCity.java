package allweather.entity.openweather;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OpenWeatherCity {

    @Id
    private Long id;

    private String name;

    private String country;

    @Embedded
    private OpenWeatherCoordinate coord;

}
