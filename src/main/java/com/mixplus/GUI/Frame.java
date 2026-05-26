package com.mixplus.GUI;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {

        setTitle("LTC7-setting");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(0x1E1E1E));
    }

    public void run() {
        setVisible(true);
    }
}