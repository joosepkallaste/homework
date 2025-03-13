package com.fujitsu.delivery_fee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.time.LocalDateTime;

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
    @EventListener(ApplicationReadyEvent.class)
    public void runOnStartup() {
        fetchWeatherData();
    }


    private void parseAndSaveWeatherData(String xml) {
        // XML Parsing logic here
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            NodeList stations = document.getElementsByTagName("station");
            for (int i = 0; i < stations.getLength(); i++) {
                Element station = (Element) stations.item(i);

                String name = station.getElementsByTagName("name").item(0).getTextContent();
                String wmoCode = station.getElementsByTagName("wmocode").item(0).getTextContent();
                double airTemperature = Double.parseDouble(station.getElementsByTagName("airtemperature").item(0).getTextContent());
                double windSpeed = Double.parseDouble(station.getElementsByTagName("windspeed").item(0).getTextContent());
                String phenomenon = station.getElementsByTagName("phenomenon").item(0).getTextContent();

                WeatherData weatherData = new WeatherData(name, wmoCode, airTemperature, windSpeed, phenomenon, LocalDateTime.now());
                weatherRepository.save(weatherData);
            }
            System.out.println("Weather data saved successfully!");
        } catch (Exception e) {
            System.err.println("Error parsing weather data: " + e.getMessage());
        }
    }
}
