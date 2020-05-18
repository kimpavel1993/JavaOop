package ru.academits.kim.main;

import ru.academits.kim.model.*;
import ru.academits.kim.scales.Celsius;
import ru.academits.kim.scales.Fahrenheit;
import ru.academits.kim.scales.Kelvin;
import ru.academits.kim.scales.Scales;
import ru.academits.kim.view.View;

public class Main {
    public static void main(String[] args) {
        Scales[] scales = new Scales[]{new Celsius(), new Fahrenheit(), new Kelvin()};

        Model model = new Model(scales);
        View view = new View(scales, model);

        view.run();
    }
}