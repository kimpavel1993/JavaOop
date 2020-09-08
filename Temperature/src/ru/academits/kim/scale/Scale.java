package ru.academits.kim.scale;

public interface Scale {
    String getName();

    double convertToCelsius(double inputTemperature);

    double convertFromCelsius(double inputTemperature);
}