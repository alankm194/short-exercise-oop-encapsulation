package com.techreturners.encapsulation.bankaccount.model;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WeatherReporter {

    private String location;
    private double temperatureInCelsius;
    private final static int MAX_TEMP_IN_CELSIUS= 30;
    private final static int MIN_TEMP_IN_CELSIUS= 10;
    private final static String DEFAULT_WEATHER = "🔆";
    private enum LOCATION {
        LONDON("London"),
        CAPE_TOWN("Cape Town"),
        CALIFORNIA("California");

        private final String label;
        private final static Map<LOCATION, String> locationWeatherMap;

        LOCATION(String label) {
           this.label = label;
        }
        static {
            locationWeatherMap = new EnumMap<>(LOCATION.class);
            locationWeatherMap.put(LOCATION.LONDON, "🌦");
            locationWeatherMap.put(LOCATION.CAPE_TOWN, "🌅");
            locationWeatherMap.put(LOCATION.CALIFORNIA, "🌤");
        }

        public static String getWeatherFromLocation(String location) {
            return Arrays.stream(LOCATION.values())
                    .filter(enumLocation -> enumLocation.label.equalsIgnoreCase(location))
                    .findFirst()
                    .map(locationWeatherMap::get)
                    .orElse(DEFAULT_WEATHER);
        }
    }


    public WeatherReporter(String location, double temperatureInCelsius) {
        this.location = location;
        this.temperatureInCelsius = temperatureInCelsius;
    }

    private double convertCelsiusToFahrenheit(double temp) {
        return (9.0 / 5.0) * temp + 32;
    }
    public String print() {
        double newTemp = convertCelsiusToFahrenheit(temperatureInCelsius);
        return MessageFormat.format("I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.",
                location,
                LOCATION.getWeatherFromLocation(location),
                getResponseFromTemperature(),
                newTemp);
    }


    private String getResponseFromTemperature() {
        if (temperatureInCelsius > MAX_TEMP_IN_CELSIUS) {

            return "It's too hot 🥵!";

        } else if (temperatureInCelsius < MIN_TEMP_IN_CELSIUS) {

            return "It's too cold 🥶!";

        }
        return "Ahhh...it's just right 😊!";
    }

}
