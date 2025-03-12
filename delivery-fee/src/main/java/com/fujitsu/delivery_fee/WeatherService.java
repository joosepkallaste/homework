package com.fujitsu.delivery_fee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    @Value("${weather.api.url}")
    private String weatherApiUrl;

    public WeatherService(WeatherRepository weatherRepository, RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
    }

    @Scheduled(cron = "0 15 * * * *")  // Runs at HH:15:00 every hour
    public void fetchWeatherData() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(weatherApiUrl, String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                parseAndSaveWeatherData(response.getBody());
            }
        } catch (Exception e) {
            System.err.println("Error fetching weather data: " + e.getMessage());
        }
    }

    private void parseAndSaveWeatherData(String xml) {
        // XML Parsing logic here...
    }
}

