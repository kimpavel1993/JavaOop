package ru.academits.kim.scale;

public class Celsius implements Scale {
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