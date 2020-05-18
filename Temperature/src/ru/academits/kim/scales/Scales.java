package ru.academits.kim.scales;

public interface Scales {
    String getName();

    double convertToCelsius(double inputTemperature);

    double convertFromCelsius(double inputTemperature);
}