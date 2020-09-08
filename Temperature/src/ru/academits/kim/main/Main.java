package ru.academits.kim.main;

import ru.academits.kim.model.*;
import ru.academits.kim.scale.Celsius;
import ru.academits.kim.scale.Fahrenheit;
import ru.academits.kim.scale.Kelvin;
import ru.academits.kim.scale.Scale;
import ru.academits.kim.view.View;

public class Main {
    public static void main(String[] args) {
        Scale[] scales = new Scale[]{new Celsius(), new Fahrenheit(), new Kelvin()};

        Model model = new Model(scales);
        View view = new View(scales, model);

        view.run();
    }
}