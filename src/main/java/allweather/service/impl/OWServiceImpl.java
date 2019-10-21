package allweather.service.impl;

import allweather.gateways.elasticsearch.ESClient;
import allweather.gateways.openweather.OpenWeatherClient;
import allweather.gateways.openweather.protocol.OpenWeatherEsObject;
import allweather.gateways.openweather.protocol.OpenWeatherForecastResponse;
import allweather.gateways.openweather.protocol.OpenWeatherResponse;
import allweather.service.OWService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import java.util.Map;

@Service
public class OWServiceImpl implements OWService {

    private final ESClient esClient;

    private final OpenWeatherClient openWeatherClient;

    private final ObjectMapper objectMapper;


    @Autowired
    public OWServiceImpl(ESClient esClient, OpenWeatherClient openWeatherClient, ObjectMapper objectMapper) {
        this.esClient = esClient;
        this.openWeatherClient = openWeatherClient;
        this.objectMapper = objectMapper;
    }


    @Override
    public OpenWeatherEsObject updateService() throws IOException {
        OpenWeatherResponse openWeatherResponse = openWeatherClient.getCurrentWeather();
        OpenWeatherForecastResponse openWeatherForecastResponse = openWeatherClient.getForecastWeather();
        OpenWeatherEsObject esObject = new OpenWeatherEsObject();
        //todo: modelMapper here?
        esObject.setDt(openWeatherResponse.getDt());
        esObject.setRequestTime(openWeatherResponse.getDt()*1000);
        esObject.setCityName(openWeatherResponse.getName());
        esObject.setCityId(openWeatherResponse.getId());
        esObject.setMain(openWeatherResponse.getMain());
        esObject.setWeather(openWeatherResponse.getWeather());
        esObject.setClouds(openWeatherResponse.getClouds());
        esObject.setWind(openWeatherResponse.getWind());
        esObject.setSys(openWeatherResponse.getSys());
        esObject.setCoord(openWeatherResponse.getCoord());
        esObject.setForecasts(openWeatherForecastResponse.getList());
        addToEs(esObject);
        return esObject;
    }

    private void addToEs(OpenWeatherEsObject esObject) throws IOException {
        Map<String, Object> map = objectMapper.convertValue(esObject, Map.class);
        esClient.insertIndexData(map, "openweather");
    }
}
