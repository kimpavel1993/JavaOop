package ru.academits.kim.scale;

public class KelvinScale implements Scale {
    @Override
    public String getName() {
        return "Градусы Кельвина";
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