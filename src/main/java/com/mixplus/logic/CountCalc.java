package com.mixplus.logic;

public class CountCalc {
    private final double ZCount;
    private final double YCount;

    private static final double ZZ = 8.719162353796259 * 0.9;
    private static final double ZY = 0.010813717832597134 * 1.5;
    // y加速1回分
    private static final double YZ = 4.185329931870182 * 0.9;
    private static final double YY = 4.708496168414073 * 1.5;


    public CountCalc(double OriginZ, double OriginY, double TargetZ, double TargetY) {
        double DiffZ = TargetZ - OriginZ;
        double DiffY = TargetY - OriginY;

        double det = ZZ * YY - YZ * ZY;

        ZCount = (DiffZ * YY - DiffY * YZ) / det;
        YCount = (ZZ * DiffY - ZY * DiffZ) / det;
        System.out.println("OriginZ=" + OriginZ);
        System.out.println("TargetZ=" + TargetZ);
        System.out.println("OriginY=" + OriginY);
        System.out.println("TargetY=" + TargetY);

        System.out.println("DiffZ=" + DiffZ);
        System.out.println("DiffY=" + DiffY);

    }



    public double getZCount() {
        return ZCount;
    }

    public double getYCount() {
        return YCount;
    }

}
