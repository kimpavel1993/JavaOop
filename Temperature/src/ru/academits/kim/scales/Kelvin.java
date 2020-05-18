package ru.academits.kim.scales;

public class Kelvin implements Scales {
    @Override
    public String getName() {
        return "Градусы Кельвин";
    }

    @Override
    public double convertToCelsius(double inputTemperature) {
        return inputTemperature - 273.15;
    }

    @Override
    public double convertFromCelsius(double inputTemperature) {
        return inputTemperature + 273.15;
    }
}