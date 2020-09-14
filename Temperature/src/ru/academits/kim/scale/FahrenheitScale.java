package ru.academits.kim.scale;

public class FahrenheitScale implements Scale {
    @Override
    public String getName() {
        return "Градусы Фаренгейта";
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