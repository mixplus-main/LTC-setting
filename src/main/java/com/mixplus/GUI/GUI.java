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















        Label OriginText = new Label("Origin");
        OriginText.setBounds(650,20,100,25);
        OriginText.setFont(new Font("Arial", Font.PLAIN, 18));

        Label Origin_z = new Label("Z:");
        Origin_z.setBounds(580,60,20,15);
        Origin_z.setFont(new Font("Arial", Font.PLAIN, 18));

        TextBox Origin_z_box = new TextBox();
        Origin_z_box.setBounds(600,54,200,26);
        Origin_z_box.setFont(new Font("Arial", Font.PLAIN, 15));

        Label Origin_y = new Label("Y:");
        Origin_y.setBounds(580,90,20,15);
        Origin_y.setFont(new Font("Arial", Font.PLAIN, 18));

        TextBox Origin_y_box = new TextBox();
        Origin_y_box.setBounds(600,84,200,26);
        Origin_y_box.setFont(new Font("Arial", Font.PLAIN, 15));



        Label TargetText = new Label("Target");
        TargetText.setBounds(650,120,70,20);
        TargetText.setFont(new Font("Arial", Font.PLAIN, 20));

        Label Target_z = new Label("Z:");
        Target_z.setBounds(580,154,20,15);
        Target_z.setFont(new Font("Arial", Font.PLAIN, 18));

        TextBox Target_z_box = new TextBox();
        Target_z_box.setBounds(600,150,200,26);
        Target_z_box.setFont(new Font("Arial", Font.PLAIN, 15));

        Label Target_y = new Label("Y:");
        Target_y.setBounds(580,182,20,15);
        Target_y.setFont(new Font("Arial", Font.PLAIN, 18));

        TextBox Target_y_box = new TextBox();
        Target_y_box.setBounds(600,178,200,26);
        Target_y_box.setFont(new Font("Arial", Font.PLAIN, 15));



        //diff calc gui
        Label Diff = new Label("   Diff");
        Diff.setBounds(650,210,70,20);
        Diff.setFont(new Font("Arial", Font.PLAIN, 20));

        Label Diff_z = new Label("Z:");
        Diff_z.setBounds(580,235,20,15);
        Diff_z.setFont(new Font("Arial", Font.PLAIN, 18));

        TextBox Diff_z_box = new TextBox();
        Diff_z_box.setBounds(600,230,200,26);
        Diff_z_box.setFont(new Font("Arial", Font.PLAIN, 15));

        Label Diff_y = new Label("Y:");
        Diff_y.setBounds(580,265,20,15);
        Diff_y.setFont(new Font("Arial", Font.PLAIN, 18));

        TextBox Diff_y_box = new TextBox();
        Diff_y_box.setBounds(600,260,200,26);
        Diff_y_box.setFont(new Font("Arial", Font.PLAIN, 15));





        frame.add(OriginText);
        frame.add(Origin_z);
        frame.add(Origin_z_box);
        frame.add(Origin_y);
        frame.add(Origin_y_box);
        frame.add(TargetText);
        frame.add(Target_z);
        frame.add(Target_z_box);
        frame.add(Target_y);
        frame.add(Target_y_box);
        frame.add(Diff);
        frame.add(Diff_z);
        frame.add(Diff_z_box);
        frame.add(Diff_y);
        frame.add(Diff_y_box);
    }

}