package com.mixplus.GUI;

import javax.swing.*;
import java.awt.*;

import com.mixplus.logic.MotionCalc;


public class GUI extends JFrame{
    private final Frame frame;
    public GUI() {
        frame = new Frame();
        init();
        frame.run();
    }

    private void init() {

        Label MotionCalcText = new Label("MotionCalc");
        MotionCalcText.setBounds(80,20,100,40);
        MotionCalcText.setFont(new Font("Arial", Font.PLAIN, 20));

        Label num_z = new Label("Z:");
        num_z.setBounds(60,70,20,18);
        num_z.setFont(new Font("Arial", Font.PLAIN, 18));

        TextBox z_box = new TextBox();
        z_box.setBounds(80,68,90,25);

        Label num_y = new Label("Y:");
        num_y.setBounds(180,70,20,18);
        num_y.setFont(new Font("Arial", Font.PLAIN, 18));

        TextBox y_box = new TextBox();
        y_box.setBounds(200,68,90,25);

        Button Calc = new Button("Calc");
        Calc.setBounds(70, 100, 110, 30);

        Label result = new Label("");
        result.setBounds(68, 140, 505, 30);
        result.setFont(new Font("Arial", Font.PLAIN, 20));

        TextBox result_box = new TextBox();
        result_box.setBounds(200, 100, 300, 30);


        Calc.addActionListener(e -> {
            int z = Integer.parseInt(z_box.getText());
            int y = Integer.parseInt(y_box.getText());
            MotionCalc.Vec v = MotionCalc.calc(Integer.parseInt(String.valueOf(z)), Integer.parseInt(String.valueOf(y)));
            result.setText("result: [0.0, %f, %f]".formatted(v.y,v.z));
            result_box.setText("[0.0, %f, %f]".formatted(v.y,v.z));
        });

        Label targetText = new Label("Target");
        targetText.setBounds(650,20,100,40);
        targetText.setFont(new Font("Arial", Font.PLAIN, 20));



        frame.add(MotionCalcText);
        frame.add(num_z);
        frame.add(z_box);
        frame.add(num_y);
        frame.add(y_box);
        frame.add(Calc);
        frame.add(result);
        frame.add(result_box);
        frame.add(targetText);
    }

}
