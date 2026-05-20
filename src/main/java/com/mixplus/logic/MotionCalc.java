package com.mixplus.logic;




public class MotionCalc {
    private double z;
    private double y;

    public void add_z(int num_x) {

        double z_z = 0;
        double z_y = 0;
        this.z += num_x * z_z;
        this.y += num_x * z_y;
    }

    public void add_y(int num_y) {
        double y_y = 0;
        double y_z = 0;
        this.z += num_y * y_z;
        this.y += num_y * y_y;
    }

    public double getZ() {
        return this.z;
    }

    public double getY() {
        return this.y;
    }
}