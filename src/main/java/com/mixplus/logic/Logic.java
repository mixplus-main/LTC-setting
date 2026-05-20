package com.mixplus.logic;

import java.util.Scanner;


public class Logic {
    MotionCalc calc = new MotionCalc();
    public void logic() {
        System.out.println("Logic");


        Scanner sc = new Scanner(System.in);

        System.out.print("num z:");
        String num_z = sc.nextLine();

        System.out.print("num y:");
        String num_y = sc.nextLine();

        try {
            calc.add_z(Integer.parseInt(num_z));
            calc.add_y(Integer.parseInt(num_y));
        } catch (NumberFormatException e) {
            System.out.println("Only integer data types are supported");
            System.out.println("\u001B[31m" + e + "\u001B[0m");
            return;
        }

        double z = calc.getZ();
        double y = calc.getY();
        System.out.println("motion\nz:" + z + "\ny:" + y);
        System.out.printf("[0, %f, %f]".formatted(y,z));




    }
}
