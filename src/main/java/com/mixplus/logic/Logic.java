package com.mixplus.logic;

import com.mixplus.GUI.GUI;
import java.util.Scanner;
import javax.swing.*;


public class Logic {
    public void logic() {

        Scanner sc = new Scanner(System.in);

        System.out.println("1: motion calc     The motion is determined from the number of accelerations in the z and y directions.");
        System.out.print("select logic:");
        String logic = sc.nextLine();


        if (logic.equalsIgnoreCase("1") || logic.equalsIgnoreCase("CUI")) {
            System.out.print("num z:");
            String num_z = sc.nextLine();

            System.out.print("num y:");
            String num_y = sc.nextLine();

            MotionCalc.Vec v = MotionCalc.calc(Integer.parseInt(num_z), Integer.parseInt(num_y));


            System.out.println(v.y);
            System.out.println(v.z);
            System.out.println("motion\nz:" + v.z + "\ny:" + v.y);
            System.out.printf("[0.0, %f, %f]".formatted(v.y,v.z));
        }
        else if (logic.equalsIgnoreCase("2") || logic.equalsIgnoreCase("GUI")) {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ignored) {}
            GUI GUI = new GUI();
            CountCalc c = new CountCalc(0,50,1);
            System.out.println(c.GetCount());
        }

    }

}
