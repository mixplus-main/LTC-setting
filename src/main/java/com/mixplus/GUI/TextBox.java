package com.mixplus.GUI;

import javax.swing.*;
import java.awt.*;

public class TextBox extends JTextField {

    public TextBox() {
        super();

        setOpaque(true);

        setBackground(new Color(0x333333));     // ダークボタン
        setForeground(Color.lightGray);

        setFont(new Font("Arial", Font.PLAIN, 14));
    }
}
