package allweather.repository;

import allweather.entity.openweather.OpenWeatherCity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenWeatherCityRepository extends CrudRepository<OpenWeatherCity, Long> {

    OpenWeatherCity findByName(String name);
}
