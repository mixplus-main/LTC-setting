package com.mixplus.logic;




public class MotionCalc {
    // z加速1回分
    private static final double Z_Y = -0.1282440322;
    private static final double Z_Z = 6.2604024704;

    // y加速1回分
    private static final double Y_Y = 1.8951126165;
    private static final double Y_Z = 4.9869190454;

    public static class Vec {
        public double y;
        public double z;

        public Vec(double y, double z) {
            this.y = y;
            this.z = z;
        }
    }

    public static Vec calc(int nZ, int nY) {

        double vY = nZ * Z_Y + nY * Y_Y;
        double vZ = nZ * Z_Z + nY * Y_Z;

        return new Vec(vY, vZ);
    }
}