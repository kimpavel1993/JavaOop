package ru.academits.kim.main;

import ru.academits.kim.model.*;
import ru.academits.kim.scale.CelsiusScale;
import ru.academits.kim.scale.FahrenheitScale;
import ru.academits.kim.scale.KelvinScale;
import ru.academits.kim.scale.Scale;
import ru.academits.kim.view.View;

public class Main {
    public static void main(String[] args) {
        Scale[] scales = new Scale[]{new CelsiusScale(), new FahrenheitScale(), new KelvinScale()};

        Model model = new Model(scales);

        View view = new View(model);

        view.run();
    }
}