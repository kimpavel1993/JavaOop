package ru.academits.kim.main;

import ru.academits.kim.model.*;
import ru.academits.kim.scale.CelsiusScale;
import ru.academits.kim.scale.FahrenheitScale;
import ru.academits.kim.scale.KelvinScale;
import ru.academits.kim.scale.Scale;
import ru.academits.kim.view.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Scale[] scales = new Scale[]{new CelsiusScale(), new FahrenheitScale(), new KelvinScale()};

        Model model = new Model(scales);

        SwingUtilities.invokeLater(() -> {
            View view = new View(scales, model);

            view.run();
        });
    }
}