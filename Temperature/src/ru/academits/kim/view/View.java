package ru.academits.kim.view;

import ru.academits.kim.model.*;
import ru.academits.kim.scale.Scale;

import javax.swing.*;
import java.awt.*;

public class View {
    JFrame frame;
    JPanel panel;
    JLabel initialLabel;
    JLabel resultLabel;
    JButton resultButton;
    JButton clearButton;
    JTextField initialTextField;
    JTextField resultTextField;
    JComboBox<String> initialComboBox;
    JComboBox<String> resultComboBox;
    Model model;

    public View(Model model) {
        this.model = model;

        initialComboBox = new JComboBox<>();
        resultComboBox = new JComboBox<>();

        for (int i = 0; i < model.getScalesQuantity(); i++) {
            initialComboBox.addItem(model.getScaleName(i));
            resultComboBox.addItem(model.getScaleName(i));
        }
    }

    private void initFrame() {
        frame = new JFrame("Перевод температур");

        frame.setSize(550, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void initContent() {
        GridBagLayout gbl = new GridBagLayout();

        panel = new JPanel();

        panel.setLayout(gbl);

        GridBagConstraints c1 = new GridBagConstraints();

        c1.gridx = 1;
        c1.gridy = 0;
        c1.gridwidth = 1;
        c1.gridheight = 1;
        c1.anchor = GridBagConstraints.CENTER;
        c1.insets = new Insets(10, 0, 0, 0);

        initialLabel = new JLabel("Введите температуру: ");

        panel.add(initialLabel, c1);

        GridBagConstraints c2 = new GridBagConstraints();

        c2.gridx = 0;
        c2.gridy = 1;
        c2.gridwidth = 1;
        c2.gridheight = 1;
        c2.anchor = GridBagConstraints.CENTER;
        c2.insets = new Insets(0, 0, 0, 0);

        panel.add(initialComboBox, c2);

        GridBagConstraints c3 = new GridBagConstraints();

        c3.gridx = 1;
        c3.gridy = 1;
        c3.gridwidth = 1;
        c3.gridheight = 1;
        c3.anchor = GridBagConstraints.CENTER;
        c3.insets = new Insets(0, 0, 0, 0);

        initialTextField = new JTextField(10);

        panel.add(initialTextField, c3);

        GridBagConstraints c4 = new GridBagConstraints();

        c4.gridx = 2;
        c4.gridy = 1;
        c4.gridwidth = 1;
        c4.gridheight = 1;
        c4.anchor = GridBagConstraints.CENTER;
        c4.insets = new Insets(0, 10, 0, 0);

        resultButton = new JButton("Перевести");

        panel.add(resultButton, c4);

        GridBagConstraints c5 = new GridBagConstraints();

        c5.gridx = 3;
        c5.gridy = 1;
        c5.gridwidth = 1;
        c5.gridheight = 1;
        c5.anchor = GridBagConstraints.CENTER;
        c5.insets = new Insets(0, 10, 0, 0);

        clearButton = new JButton("Очистить");

        panel.add(clearButton, c5);

        GridBagConstraints c6 = new GridBagConstraints();

        c6.gridx = 0;
        c6.gridy = 3;
        c6.gridwidth = 1;
        c6.gridheight = 1;
        c6.anchor = GridBagConstraints.SOUTH;
        c6.insets = new Insets(10, 0, 0, 0);

        panel.add(resultComboBox, c6);

        GridBagConstraints c7 = new GridBagConstraints();

        c7.gridx = 1;
        c7.gridy = 2;
        c7.gridwidth = 1;
        c7.gridheight = 1;
        c7.anchor = GridBagConstraints.CENTER;
        c7.insets = new Insets(10, 0, 0, 0);

        resultLabel = new JLabel("Результат: ");

        panel.add(resultLabel, c7);

        GridBagConstraints c8 = new GridBagConstraints();

        c8.gridx = 1;
        c8.gridy = 3;
        c8.gridwidth = 1;
        c8.gridheight = 1;
        c8.anchor = GridBagConstraints.CENTER;
        c8.insets = new Insets(10, 0, 0, 0);

        resultTextField = new JTextField(10);

        resultTextField.setEditable(false);
        panel.add(resultTextField, c8);

        frame.setContentPane(panel);
    }

    private void initEvents() {
        resultButton.addActionListener(e -> {
            try {
                double inputTemperature = Double.parseDouble(initialTextField.getText());

                String initialScaleName = (String) initialComboBox.getSelectedItem();
                String resultScaleName = (String) resultComboBox.getSelectedItem();

                Scale initialScale = model.getScale(initialScaleName);
                Scale resultScale = model.getScale(resultScaleName);

                resultTextField.setText(String.format("%.2f", model.convert(inputTemperature, initialScale, resultScale)));
            } catch (NumberFormatException f) {
                JOptionPane.showMessageDialog(panel, "Введите цифры");
            }
        });

        clearButton.addActionListener(e -> {
            initialTextField.setText("");
            resultTextField.setText("");
        });
    }

    public void run() {
        SwingUtilities.invokeLater(() -> {
            initFrame();
            initContent();
            initEvents();
        });
    }
}