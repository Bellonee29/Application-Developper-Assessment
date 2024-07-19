package org.waysTech.ApiDevelopment;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.waysTech.ApiDevelopment.WeatherData;

@Service
public class ExternalApiService {
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherData getWeatherData(String location) {
        String url = String.format("https://api.weather.com/v3/weather/%s", location);
        return restTemplate.getForObject(url, WeatherData.class);
    }
}

