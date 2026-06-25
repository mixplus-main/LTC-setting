package com.mixplus.GUI;


import com.mixplus.logic.LoopCalc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;


public class GUI{
    private colors color;
    private final Frame frame;
    private JPanel panel;

    public GUI() {
        frame = new Frame();
        frame.setBackground(colors.MAIN_BG);
        init();
        frame.run();


    }

    private void init() {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(colors.MAIN_BG);



        ImageIcon zero = new ImageIcon(
                Objects.requireNonNull(GUI.class.getResource("/binary/0.png"))
        );
        ImageIcon one = new ImageIcon(
                Objects.requireNonNull(GUI.class.getResource("/binary/1.png"))
        );

        //panel.add(new JLabel(zero), BorderLayout.NORTH);
        //panel.add(new JLabel(one), BorderLayout.SOUTH);
        JTable table = createTable();


        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(new Color(20, 20, 20));
        scroll.setBackground(new Color(20, 20, 20));

        panel.add(scroll, BorderLayout.CENTER);

        frame.setContentPane(panel);


        //JPanel headerRow = createHeaderRow();
        //JPanel inputRow = createInputRow();

        /*
            Diff_z_box.setText(String.valueOf(loopCalc.getDz()));
            Diff_y_box.setText(String.valueOf(loopCalc.getDy()));

        });*/


    }

    public JTable createTable() {
        String spaceSTR = "    ";
        String[] columns = {
                spaceSTR + "  Calc",
                spaceSTR + "Origin",
                spaceSTR + "Target",
                spaceSTR + "Diff",
                spaceSTR + "Count"
        };

        Object[][] data = {
                {"Z", "0", "0", "0", "0"},
                {"Y", "0", "0", "0", "0"}
        };
        JTable table = new JTable(data, columns);
        TableModel model = table.getModel();



        table.getTableHeader().setOpaque(true);
        table.setBackground(colors.TABLE_BG);
        table.setForeground(Color.WHITE);
        table.setSelectionBackground(colors.SELECT_BG);
        table.setSelectionForeground(Color.WHITE);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        table.getTableHeader()
                .setDefaultRenderer(
                        new HeaderRenderer(
                                colors.HEADER_BG,
                                Color.white
                        )
                );
        table.setShowGrid(true);
        table.setGridColor(Color.WHITE);
        //table.setBorder(BorderFactory.createLineBorder(Color.WHITE));



        JTextField editor = new JTextField(" 0");

        editor.setFont(new Font("Arial", Font.PLAIN, 14));
        editor.setBackground(new Color(80, 80, 80));
        editor.setForeground(Color.WHITE);

        editor.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        table.setDefaultEditor(Object.class, new DefaultCellEditor(editor));

        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = table.columnAtPoint(e.getPoint());
                if (col == 0) {

                    //get Origin
                    Object OriginZ = model.getValueAt(0, 1);
                    Object OriginY = model.getValueAt(1, 1);

                    //get Target
                    Object TargetZ = model.getValueAt(0, 2);
                    Object TargetY = model.getValueAt(1, 2);

                    LoopCalc loopCalc = new LoopCalc(
                            Double.parseDouble((String) OriginZ),
                            Double.parseDouble((String) OriginY),
                            Double.parseDouble((String) TargetZ),
                            Double.parseDouble((String) TargetY)
                    );

                    //get Diff
                    model.setValueAt(loopCalc.getDz(), 0, 3);
                    model.setValueAt(loopCalc.getDy(), 1, 3);

                    model.setValueAt(loopCalc.getZCount(), 0, 4);
                    model.setValueAt(loopCalc.getYCount(), 1, 4);

                }
            }
        });
        

        return table;
    }

    public JPanel createHeaderRow() {
        JPanel headerRow = new JPanel(new GridLayout(1,5));

        headerRow.add(new Label(""));
        headerRow.add(new Label("Origin  "));
        headerRow.add(new Label("Target"));
        headerRow.add(new Label(" Diff"));
        headerRow.add(new Label("count"));

        panel.add(headerRow);
        return headerRow;
    }


    public JPanel createInputRow() {
        JPanel inputRow = new JPanel(new GridLayout(2, 5));






        //Z
        Label labelZ = new Label("    Z");

        TextBox originZ = new TextBox();
        TextBox targetZ = new TextBox();

        TextBox diffZ = new TextBox();
        TextBox countZ = new TextBox();

        //y
        Label labelY = new Label("    Y");

        TextBox originY = new TextBox();
        TextBox targetY = new TextBox();

        TextBox diffY = new TextBox();
        TextBox countY = new TextBox();

        inputRow.add(labelZ);
        inputRow.add(originZ);
        inputRow.add(targetZ);
        inputRow.add(diffZ);
        inputRow.add(countZ);

        inputRow.add(labelY);
        inputRow.add(originY);
        inputRow.add(targetY);
        inputRow.add(diffY);
        inputRow.add(countY);

        panel.add(inputRow);


        frame.add(panel, BorderLayout.CENTER);
        return inputRow;
    }

}