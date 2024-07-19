package org.waysTech.ApiDevelopment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class WeatherData {

    private String deviceId;
    private String deviceName;
    private Instant timestamp;
    private long timestampMs;
    private String type;
    private double value;

    public WeatherData() {
    }
}
