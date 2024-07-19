package org.waysTech.ApiDevelopment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherDataController {

    private final WeatherDataService weatherDataService;
    private final CsvService csvService;

    public WeatherDataController(WeatherDataService weatherDataService, CsvService csvService) {
        this.weatherDataService = weatherDataService;
        this.csvService = csvService;
    }

    @GetMapping("/weatherData")
    public List<WeatherData> getWeatherData() {
        return csvService.readCsvData();
    }

    @GetMapping("/sendWeatherData")
    public String sendWeatherData(@RequestParam String data) {
        weatherDataService.sendWeatherData("weather-data", data);
        return "Data sent to Kafka";
    }
}
