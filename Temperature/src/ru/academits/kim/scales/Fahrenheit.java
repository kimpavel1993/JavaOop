package ru.academits.kim.scales;

public class Fahrenheit implements Scales {
    @Override
    public String getName() {
        return "Градусы Фаренгейт";
    }

    @Override
    public double convertToCelsius(double inputTemperature) {
        return (inputTemperature - 32) / 1.8;
    }

    @Override
    public double convertFromCelsius(double inputTemperature) {
        return inputTemperature * 1.8 + 32;
    }
}