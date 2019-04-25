package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class BMI extends JFrame{

        private double calculateBMI(double h, double w, boolean formula) {
            if (formula) {
                return w/(h*h)*10000;
            } else {
                return w/(h*h)*702;
            }
        }

        private boolean Metric = true;

        private String category(double K) {
            String answer = "You're fat";
            if (K < 18.5) {
                answer = "Underweight";
            } else if (K >= 18.5 && K < 25) {
                answer = "Appropriate body weight weight";
            } else if (K >= 25 && K <= 29.9) {
                answer = "Overweight";
            }
            return answer;
        }

        public BMI() {
            this.setTitle("BMI Calculator");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);

            this.setLayout(new BorderLayout());

            JRadioButton metricButton = new JRadioButton("Metric Unit");
            JRadioButton imperialButton = new JRadioButton("Imperial Unit");
            metricButton.setSelected(true);

            ButtonGroup buttonGroup = new ButtonGroup();

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2));

            JLabel label1 = new JLabel("Height(cm):");
            JTextField textfield1 = new JTextField("");
            JLabel label2 = new JLabel("Weight(kg):");
            JTextField textfield2 = new JTextField("");

            JPanel panel2 = new JPanel();
            panel2.setLayout(new GridLayout(2, 1));

            JLabel label3 = new JLabel("                       ");
            JLabel label4 = new JLabel("                       ");

            JPanel panel3 = new JPanel();
            panel3.setLayout(new GridLayout(1, 2));

            JButton button = new JButton("Calculate BMI");
            JButton button2 = new JButton("Clean data");

            buttonGroup.add(metricButton);
            buttonGroup.add(imperialButton);

            panel.add(metricButton);
            panel.add(imperialButton);
            panel.add(label1);
            panel.add(textfield1);
            panel.add(label2);
            panel.add(textfield2);

            panel2.add(label3);
            panel2.add(label4);

            panel3.add(button);
            panel3.add(button2);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent n) {
                    double a = Double.parseDouble(textfield1.getText());
                    double b = Double.parseDouble(textfield2.getText());
                    double BMI = calculateBMI(a, b, Metric);
                    DecimalFormat df2 = new DecimalFormat("#.##");
                    label3.setText("Your BMI is " + df2.format(BMI) + ".");
                    label4.setText("Your Category is: " + category(BMI) + ".");
                }
            });

            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textfield1.setText("");
                    textfield2.setText("");
                    label3.setText("                       ");
                    label4.setText("                       ");
                }
            });

            metricButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Metric = true;
                    label1.setText("Height(cm): ");
                    label2.setText("Weight(kg): ");
                }
            });

            imperialButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Metric = false;
                    label1.setText("Height(in): ");
                    label2.setText("Weight(lb): ");
                }
            });

            this.add(panel, BorderLayout.NORTH);
            this.add(panel2, BorderLayout.CENTER);
            this.add(panel3, BorderLayout.SOUTH);

            this.setSize(600, 200);
            this.setVisible(true);
        }
    }