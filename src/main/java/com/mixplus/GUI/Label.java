package com.mixplus.GUI;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {

    public Label(String text) {
        super(text);


        setOpaque(true);
        //Color
        setBackground(new Color(0x1E1E1E));     // ダークボタン
        setForeground(Color.lightGray);

        setFont(new Font("Arial", Font.PLAIN, 14));
    }


}
