package com.mixplus.logic;




public class MotionCalc {
    // z加速1回分
    private static final double ZZ = 8.738166741870494d;
    private static final double ZY = 0.0d;
    // y加速1回分
    private static final double YZ = 4.782571109309145d;
    private static final double YY = 4.029528112788979d;

    private final int nZ;
    private final int nY;

    public MotionCalc(int nZ, int nY) {
        this.nZ = nZ;
        this.nY = nY;
    }

    public double getZ() {
        return nZ * ZZ + nY * YZ;
    }

    public double getY() {
        return nZ * ZY + nY * YY;
    }
}