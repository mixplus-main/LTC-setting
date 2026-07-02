package com.mixplus.logic;

public class CountCalc {
    private int CountZ;
    private int CountY;
    private final String binaryZ;
    private final String binaryY;
    private double dz;
    private double dy;

    private boolean error = false;

    // z加速1回分
    private static final double ZZ = 8.738166741870494d;
    private static final double ZY = 0.0d;
    // y加速1回分
    private static final double YZ = 4.782571109309145d;
    private static final double YY = 4.029528112788979d;

    public CountCalc(double OriginZ, double OriginY, double TargetZ, double TargetY) {
        System.out.println("start");
        double DiffZ = (TargetZ - OriginZ);
        double DiffY = ((TargetY + 95) - OriginY) / 1.5;
        dz = DiffZ;
        dy = DiffY;

        if (dz < 0 || dy < 0 || Math.abs(dz) <= 10 && Math.abs(dy) <= 10 || DiffZ < 107) {
            error = true;
            binaryZ = "error";
            binaryY = "error";

            dz = 00.00;
            dy = 00.00;

            return;
        }
        CountY = (int)Math.ceil(DiffY / YY);
        double UsedZ = CountY * YZ;
        System.out.println("UsedZ" +UsedZ);
        double RemainZ = DiffZ - UsedZ;
        System.out.println("RemainZ" +RemainZ);

        if (Math.abs(RemainZ) < ZZ) {
            CountZ = 0;
        } else {
            CountZ = (int)Math.round((RemainZ / ZZ) * 1.13);
        }



        binaryZ = String.format(
                "%10s", Integer.toBinaryString(CountZ))
                .replace(' ', '0');

        binaryY = String.format(
                "%10s", Integer.toBinaryString(CountY))
                .replace(' ', '0');

    }
    public int getZCount() {
        return CountZ;
    }

    public int getYCount() {
        return CountY;
    }

    public String getBinaryZ() {return binaryZ; }

    public String getBinaryY() {return binaryY; }

    public double getDz() {
        return dz;
    }

    public double getDy() {
        return dy;
    }

    public boolean getError() {
        return error;
    }
}
