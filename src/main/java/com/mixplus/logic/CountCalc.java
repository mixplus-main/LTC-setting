package com.mixplus.logic;

public class CountCalc {
    private double DiffZ;
    private double DiffY;

    // z加速1回分
    private static final double Z_Y = -0.1282440322;
    private static final double Z_Z = 6.2604024704;
    // y加速1回分
    private static final double Y_Y = 1.8951126165;
    private static final double Y_Z = 4.9869190454;

    public CountCalc(double OriginZ, double TargetZ,double OriginY, double TargetY) {
        DiffZ = TargetZ - OriginZ;
        DiffY = TargetY - OriginY;

        double det = Z_Z * Y_Y - Z_Y * Y_Z;
        double CountZ =
                (DiffZ * Y_Y - DiffY - Y_Z) / det;

        double CountY =
                (Z_Z * DiffY - Z_Y * DiffZ) / det;


        System.out.println("CountZ:" + CountZ + "CountY:" + CountY);

    }

    public double GetCount() {
        return DiffZ;
    }
}
