package ru.academits.kim.model;

import ru.academits.kim.scale.Scale;

public class Model {
    private final Scale[] scales;

    public Model(Scale[] scales) {
        this.scales = scales;
    }

    public Scale getScale(String nameScale) {
        for (Scale e : scales) {
            if (nameScale.equals(e.getName())) {
                return e;
            }
        }
        return null;
    }

    public double convert(double inputTemperature, Scale scaleFrom, Scale scaleTo) {
        double celsiusValue = scaleFrom.convertToCelsius(inputTemperature);

        return scaleTo.convertFromCelsius(celsiusValue);
    }
}