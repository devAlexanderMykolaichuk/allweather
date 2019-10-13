package allweather.repository;

import allweather.entity.openweather.OpenWeatherCity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenWeatherCityRepository extends CrudRepository<OpenWeatherCity, Long> {

    @Query("SELECT a.id from OpenWeatherCity as a where a.name = :name")
    Long findIdByName(String name);
}
