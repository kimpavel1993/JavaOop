package ru.academits.kim.scales;

public class Celsius implements Scales {
    @Override
    public String getName() {
        return "Градусы Цельсия";
    }

    @Override
    public double convertToCelsius(double inputTemperature) {
        return inputTemperature;
    }

    @Override
    public double convertFromCelsius(double inputTemperature) {
        return inputTemperature;
    }
}