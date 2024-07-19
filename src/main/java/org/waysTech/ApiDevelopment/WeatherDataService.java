package org.waysTech.ApiDevelopment;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public WeatherDataService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendWeatherData(String topic, String data) {
        kafkaTemplate.send(topic, data);
    }
}

