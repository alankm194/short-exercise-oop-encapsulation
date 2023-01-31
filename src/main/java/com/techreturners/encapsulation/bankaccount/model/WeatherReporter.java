package com.techreturners.encapsulation.bankaccount.model;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WeatherReporter {
    enum LOCATION {
        LONDON("London"),
        CAPE_TOWN("Cape Town"),
        CALIFORNIA("California");

        private final String label;

        LOCATION(String label) {
            this.label = label;
        }

        private String getLabel() {
            return label;
        }
    }
    private String location;
    private double temperatureInCelsius;
    private final static int MAX_TEMP_IN_CELSIUS = 30;
    private final static int MIN_TEMP_IN_CELSIUS = 10;
    private final static String DEFAULT_WEATHER_EMOJI = "🔆";
    private final static Map<LOCATION, String> locationWeatherMap;

    static {
        locationWeatherMap = new EnumMap<>(LOCATION.class);
        locationWeatherMap.put(LOCATION.LONDON, "🌦");
        locationWeatherMap.put(LOCATION.CAPE_TOWN, "🌅");
        locationWeatherMap.put(LOCATION.CALIFORNIA, "🌤");
    }

    public WeatherReporter(String location, double temperatureInCelsius) {
        this.location = location;
        this.temperatureInCelsius = temperatureInCelsius;
    }

    private double convertCelsiusToFahrenheit(double temp) {
        final int fahrenheitConstant = 32;
        final double fahrenheitFraction = (9.0 / 5.0);
        return fahrenheitFraction * temp + fahrenheitConstant;
    }
    public String print() {
        return MessageFormat.format("I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.",
                location,
                getWeatherEmojiFromLocation(location),
                getResponseFromTemperature(),
                convertCelsiusToFahrenheit(temperatureInCelsius));
    }

    private static String getWeatherEmojiFromLocation(String location) {
        return Arrays.stream(LOCATION.values())
                .filter(enumLocation -> enumLocation.getLabel().equalsIgnoreCase(location))
                .findFirst()
                .map(locationWeatherMap::get)
                .orElse(DEFAULT_WEATHER_EMOJI);
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
