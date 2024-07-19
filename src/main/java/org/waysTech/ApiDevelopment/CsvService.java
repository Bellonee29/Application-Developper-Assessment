package org.waysTech.ApiDevelopment;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {

    private static final String SAMPLE_CSV_FILE_PATH = "path/to/Data-Assessment.csv";

    public List<WeatherData> readCsvData() {
        List<WeatherData> weatherDataList = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                String deviceId = csvRecord.get("device-id");
                String deviceName = csvRecord.get("device-name");
                Instant timestamp = Instant.parse(csvRecord.get("timestamp"));
                long timestampMs = Long.parseLong(csvRecord.get("timestamp-ms"));
                String type = csvRecord.get("type");
                double value = Double.parseDouble(csvRecord.get("value"));

                WeatherData weatherData = new WeatherData(deviceId, deviceName, timestamp, timestampMs, type, value);
                weatherDataList.add(weatherData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherDataList;
    }
}