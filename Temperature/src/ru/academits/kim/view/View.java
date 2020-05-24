package ru.academits.kim.view;

import ru.academits.kim.model.*;
import ru.academits.kim.scales.Scales;

import javax.swing.*;
import java.awt.*;

public class View {
    private final JFrame frame = new JFrame("Перевод температур");
    private final JPanel panel = new JPanel();
    private final JLabel initialLabel = new JLabel("Введите температуру: ");
    private final JLabel resultLabel = new JLabel("Результат: ");
    private final JButton resultButton = new JButton("Перевести");
    private final JButton clearButton = new JButton("Очистить");
    private final JTextField initialTextField = new JTextField(10);
    private final JTextField resultTextField = new JTextField(10);
    private final JComboBox<String> initialComboBox = new JComboBox<>();
    private final JComboBox<String> resultComboBox = new JComboBox<>();
    private final Model model;

    public View(Scales[] scales, Model model) {
        this.model = model;

        for (Scales scale : scales) {
            initialComboBox.addItem(scale.getName());
            resultComboBox.addItem(scale.getName());
        }
    }

    private void initialFrame() {
        frame.setSize(550, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    private void initialContent() {
        GridBagLayout gbl = new GridBagLayout();

        panel.setLayout(gbl);

        GridBagConstraints c1 = new GridBagConstraints();

        c1.gridx = 1;
        c1.gridy = 0;
        c1.gridwidth = 1;
        c1.gridheight = 1;
        c1.anchor = GridBagConstraints.CENTER;
        c1.insets = new Insets(10, 0, 0, 0);

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

        panel.add(initialTextField, c3);

        GridBagConstraints c4 = new GridBagConstraints();

        c4.gridx = 2;
        c4.gridy = 1;
        c4.gridwidth = 1;
        c4.gridheight = 1;
        c4.anchor = GridBagConstraints.CENTER;
        c4.insets = new Insets(0, 10, 0, 0);

        panel.add(resultButton, c4);

        GridBagConstraints c5 = new GridBagConstraints();

        c5.gridx = 3;
        c5.gridy = 1;
        c5.gridwidth = 1;
        c5.gridheight = 1;
        c5.anchor = GridBagConstraints.CENTER;
        c5.insets = new Insets(0, 10, 0, 0);

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

        panel.add(resultLabel, c7);

        GridBagConstraints c8 = new GridBagConstraints();

        c8.gridx = 1;
        c8.gridy = 3;
        c8.gridwidth = 1;
        c8.gridheight = 1;
        c8.anchor = GridBagConstraints.CENTER;
        c8.insets = new Insets(10, 0, 0, 0);

        resultTextField.setEditable(false);
        panel.add(resultTextField, c8);

        frame.setContentPane(panel);
    }

    private void initialEvents() {
        resultButton.addActionListener(e -> {
            try {
                double inputTemperature = Double.parseDouble(initialTextField.getText());

                String initialNameScale = (String) initialComboBox.getSelectedItem();
                String resultNameScale= (String) resultComboBox.getSelectedItem();

                int initialScale = model.getScaleIndex(initialNameScale);
                int resultScale = model.getScaleIndex(resultNameScale);

                model.convert(inputTemperature, initialScale, resultScale);

                resultTextField.setText(String.format("%.2f", model.getOutputTemperature()));
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
            initialFrame();
            initialContent();
            initialEvents();
        });
    }
}