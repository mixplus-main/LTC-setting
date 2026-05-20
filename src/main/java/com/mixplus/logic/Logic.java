package com.mixplus.logic;

import java.util.Scanner;


public class Logic {
    public void logic() {

        Scanner sc = new Scanner(System.in);

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
}
