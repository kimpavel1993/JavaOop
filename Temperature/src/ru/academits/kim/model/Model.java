package ru.academits.kim.model;

import ru.academits.kim.scale.Scale;

public class Model {
    private final Scale[] scales;

    public Model(Scale[] scales) {
        this.scales = scales;
    }

    public int getScalesQuantity() {
        int scalesQuantity = 0;

        for (int i = 0; i < scales.length; i++) {
            scalesQuantity += i;
        }

        return scalesQuantity;
    }

    public String getScaleName(int index) {
        for (int i = 0; i < getScalesQuantity(); i++) {
            if (i == index) {
                return scales[index].getName();
            }
        }

        return null;
    }

    public Scale getScale(String scaleName) {
        for (Scale e : scales) {
            if (scaleName.equals(e.getName())) {
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