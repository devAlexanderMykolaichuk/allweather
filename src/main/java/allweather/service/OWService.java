package allweather.service;

import allweather.gateways.openweather.protocol.OpenWeatherEsObject;

import java.io.IOException;

public interface OWService {

    OpenWeatherEsObject updateService() throws IOException;
}
