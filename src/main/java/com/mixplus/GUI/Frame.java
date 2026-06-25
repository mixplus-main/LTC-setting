package com.mixplus.GUI;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {

        setTitle("LTC7-setting");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //getContentPane().setBackground(new Color(0x1E1E1E));
        getContentPane().setBackground(Color.BLACK);
    }

    public void run() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}