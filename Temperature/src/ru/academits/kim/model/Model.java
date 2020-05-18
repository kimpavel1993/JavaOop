package ru.academits.kim.model;

import ru.academits.kim.scales.Scales;

public class Model {
    private double outputTemperature;
    private final Scales[] scales;

    public Model(Scales[] scales) {
        this.scales = scales;
    }

    public double getOutputTemperature() {
        return outputTemperature;
    }

    private void setOutputTemperature(double outputTemperature) {
        this.outputTemperature = outputTemperature;

    }

    public int getScaleIndex(String scaleName) {
        for (int i = 0; i < scales.length; i++) {
            if (scaleName.equals(scales[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    public void convert(double inputTemperature, int scaleIndexFrom, int scaleIndexTo) {
        double celsiusValue = scales[scaleIndexFrom].convertToCelsius(inputTemperature);

        setOutputTemperature(scales[scaleIndexTo].convertFromCelsius(celsiusValue));
    }
}