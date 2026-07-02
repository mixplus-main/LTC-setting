package com.mixplus.logic;

import com.mixplus.Config;
import com.mixplus.FileType;
import com.mixplus.GUI.GUI;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;


public class Logic {
    public void logic() {
        Config config = new Config("config.prorerties", FileType.PROPERTIES);
        config.createFile();
        try {config.load();} catch (IOException e) {e.printStackTrace();}

        Scanner sc = new Scanner(System.in);

        System.out.print("select logic:");
        String logic = sc.nextLine();



        if (logic.equalsIgnoreCase("2") || logic.equalsIgnoreCase("GUI")) {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ignored) {}
            GUI GUI = new GUI(config);


        }


    }

}
