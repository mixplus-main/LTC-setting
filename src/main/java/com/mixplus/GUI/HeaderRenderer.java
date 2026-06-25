package com.mixplus.GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class HeaderRenderer extends DefaultTableCellRenderer {
    private final Color bg;
    private final Color fg;

    public HeaderRenderer(Color bg, Color fg) {
        this.bg = bg;
        this.fg = fg;
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column
    ) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column
        );

        label.setOpaque(true);
        label.setBackground(bg);
        label.setForeground(fg);
        return label;
    }
}
