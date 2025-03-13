package com.fujitsu.delivery_fee;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryFeeService {
    private final WeatherRepository weatherRepository;

    public DeliveryFeeService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public double calculateDeliveryFee(String city, String vehicleType) {
        double baseFee = getBaseFee(city, vehicleType);
        double extraFee = getExtraFees(city, vehicleType);
        return baseFee + extraFee;
    }

    private double getBaseFee(String city, String vehicleType) {
        if ("Tallinn".equals(city)) {
            return switch (vehicleType) {
                case "Car" -> 4.0;
                case "Scooter" -> 3.5;
                case "Bike" -> 3.0;
                default -> 0.0;
            };
        }
        if ("Tartu".equals(city)) {
            return switch (vehicleType) {
                case "Car" -> 3.5;
                case "Scooter" -> 3.0;
                case "Bike" -> 2.5;
                default -> 0.0;
            };
        }
        if ("Pärnu".equals(city)) {
            return switch (vehicleType) {
                case "Car" -> 3.0;
                case "Scooter" -> 2.5;
                case "Bike" -> 2.0;
                default -> 0.0;
            };
        }
        return 0.0;
    }

    private double getExtraFees(String city, String vehicleType) {
        Optional<WeatherData> latestWeather = weatherRepository.findTopByStationNameOrderByTimestampDesc(city);
        if (latestWeather.isEmpty()) return 0.0;

        WeatherData weather = latestWeather.get();
        double extraFee = 0.0;

        if (vehicleType.equals("Scooter") || vehicleType.equals("Bike")) {
            if (weather.getAirTemperature() < -10) extraFee += 1.0;
            else if (weather.getAirTemperature() >= -10 && weather.getAirTemperature() < 0) extraFee += 0.5;
        }

        if (vehicleType.equals("Bike")) {
            if (weather.getWindSpeed() >= 10 && weather.getWindSpeed() < 20) extraFee += 0.5;
            if (weather.getWindSpeed() >= 20) throw new RuntimeException("Usage of selected vehicle type is forbidden");
        }

        if (vehicleType.equals("Scooter") || vehicleType.equals("Bike")) {
            if (weather.getWeatherPhenomenon().contains("snow") || weather.getWeatherPhenomenon().contains("sleet"))
                extraFee += 1.0;
            if (weather.getWeatherPhenomenon().contains("rain")) extraFee += 0.5;
            if (weather.getWeatherPhenomenon().contains("glaze") || weather.getWeatherPhenomenon().contains("hail")
                    || weather.getWeatherPhenomenon().contains("thunder"))
                throw new RuntimeException("Usage of selected vehicle type is forbidden");
        }

        return extraFee;
    }
}
