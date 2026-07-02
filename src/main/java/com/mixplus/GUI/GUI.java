package com.mixplus.GUI;


import com.mixplus.Config;
import com.mixplus.logic.CountCalc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GUI{
    private static final Logger logger = Logger.getLogger(GUI.class.getName());
    private CountCalc countcalc;
    private colors color;

    private final Frame frame;
    private JPanel binaryPanel;

    private final ImageIcon zero = new ImageIcon(
            new ImageIcon(
                    Objects.requireNonNull(getClass()
                            .getResource("/binary/0.png")))
                    .getImage()
                    .getScaledInstance(48, 48, Image.SCALE_SMOOTH)
    );

    private final ImageIcon one = new ImageIcon(
            new ImageIcon(
                    Objects.requireNonNull(getClass()
                            .getResource("/binary/1.png")))
                    .getImage()
                    .getScaledInstance(48, 48, Image.SCALE_SMOOTH)
    );

    private final Config config;

    public GUI(Config config) {
        this.config = config;
        frame = new Frame();
        frame.setBackground(colors.MAIN_BG);
        init();
        frame.run();


    }

    private void init() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colors.MAIN_BG);

        binaryPanel = createBinaryPanel();
        panel.add(binaryPanel, BorderLayout.SOUTH);

        JTable table = createTable();


        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(new Color(20, 20, 20));
        scroll.setBackground(new Color(20, 20, 20));

        panel.add(scroll, BorderLayout.CENTER);

        frame.setContentPane(panel);

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
                {"Z", config.getString("OriginZ", "0"),
                        config.getString("TargetZ", "0"), "0", "0"},

                {"Y", config.getString("OriginY", "0"),
                        config.getString("TargetY", "0"), "0", "0"}
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

                    config.set("OriginZ", OriginZ);
                    config.set("OriginY", OriginY);

                    //get Target
                    Object TargetZ = model.getValueAt(0, 2);
                    Object TargetY = model.getValueAt(1, 2);

                    config.set("TargetZ", TargetZ);
                    config.set("TargetY", TargetY);

                    countcalc = new CountCalc(
                            Double.parseDouble((String) OriginZ),
                            Double.parseDouble((String) OriginY),
                            Double.parseDouble((String) TargetZ),
                            Double.parseDouble((String) TargetY)
                    );

                    //get Diff
                    model.setValueAt(countcalc.getDz(), 0, 3);
                    model.setValueAt(countcalc.getDy(), 1, 3);


                    model.setValueAt(countcalc.getZCount(), 0, 4);
                    model.setValueAt(countcalc.getYCount(), 1, 4);



                    boolean binaryUpdate = BinaryUpdate(
                            countcalc.getBinaryZ(), countcalc.getBinaryY()
                    );

                    if (!binaryUpdate) {
                        model.setValueAt("error", 0, 3);
                        model.setValueAt("error", 1, 3);
                    }

                    try {config.save();} catch (IOException er) {
                        logger.log(Level.SEVERE, "Failed to save file", er);
                    }

                }
            }
        });
        

        return table;
    }

    public JPanel createBinaryPanel() {
        JPanel binaryPanel = new JPanel(new GridLayout(2, 11));

        binaryPanel.add(new JLabel("Z"))
                .setFont(new Font("Arial", Font.PLAIN, 20));
        for (int i = 0; i < 10; i++) {
            binaryPanel.add(new JLabel(zero));
        }

        binaryPanel.add(new Label("Y"))
                .setFont(new Font("Arial", Font.PLAIN, 20));
        for (int i = 0; i < 10; i++) {
            binaryPanel.add(new JLabel(zero));
        }

        return binaryPanel;
    }

    public boolean BinaryUpdate(String binaryZ, String binaryY) {
        if (binaryZ.equals("error") || binaryY.equals("error")) {
            return false;
        }
        binaryPanel.removeAll();
        binaryPanel.revalidate();
        binaryPanel.repaint();

        binaryPanel.add(new JLabel("Z"))
                .setFont(new Font("Arial", Font.PLAIN, 14));
        for (char bit : binaryZ.toCharArray()) {
            binaryPanel.add(
                    new JLabel(bit == '0' ? zero : one)
            );
        }

        binaryPanel.add(new JLabel("Y"))
                .setFont(new Font("Arial", Font.PLAIN, 20));
        for (char bit : binaryY.toCharArray()) {
            binaryPanel.add(
                    new JLabel(bit == '0' ? zero : one)
            );
        }
        System.out.println("updated");
        binaryPanel.revalidate();
        binaryPanel.repaint();
        return true;
    }
}