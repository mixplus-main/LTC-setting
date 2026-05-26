package com.mixplus.GUI;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    public Button(String text) {
        super(text);

        style();
    }

    private void style() {
        setFocusPainted(false);                 // 青枠消す
        setBorderPainted(false);                // 枠制御
        setContentAreaFilled(true);             // 背景有効
        setOpaque(true);

        //Color
        setBackground(new Color(0x333333));     // ダークボタン
        setForeground(Color.lightGray);

        setFont(new Font("Arial", Font.PLAIN, 14));
    }
}