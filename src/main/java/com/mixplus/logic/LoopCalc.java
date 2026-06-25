package com.mixplus.logic;

public class LoopCalc {
    private int ZCount;
    private int YCount;
    private final String binaryZ;
    private final String binaryY;
    private double dz;
    private double dy;

    // z加速1回分
    private static final double ZZ = 8.737016398539938d;
    private static final double ZY = 0.0d;
    // y加速1回分
    private static final double YZ = 4.782571109309145d;
    private static final double YY = 4.029528112788979d;

    public LoopCalc(double OriginZ, double OriginY, double TargetZ, double TargetY) {
        double DiffZ = TargetZ - OriginZ;
        double DiffY = (TargetY + 95) - OriginY;
        double dz = DiffZ;
        double dy = DiffY;


        while (Math.abs(DiffZ) > 5 && Math.abs(DiffY) > 5) {
            if (DiffZ > DiffY) {
                DiffZ -= ZZ;
                DiffY -= ZY;
                ++ZCount;
            } else if (DiffY > DiffZ) {
                DiffZ -= YZ;
                DiffY -= YY;
                ++YCount;

            }

            if (Math.abs(DiffZ) <= 5) {
                DiffZ -= YZ;
                DiffY -= YY;
                ++YCount;
            }
            else if(Math.abs(DiffY) <= 5) {
                DiffZ -= ZZ;
                DiffY -= ZY;
                ++ZCount;
            }

        }
        binaryZ = String.format(
                "%10s", Integer.toBinaryString(ZCount))
                .replace(' ', '0');

        binaryY = String.format(
                "%10s", Integer.toBinaryString(YCount))
                .replace(' ', '0');

        System.out.println("ZBinary: " + binaryZ);
        System.out.println("YBinary: " + binaryY);
    }
    public int getZCount() {
        return ZCount;
    }

    public int getYCount() {
        return YCount;
    }

    public String getBinaryZ() {return binaryZ; }

    public String getBinaryY() {return binaryY; }

    public double getDz() {
        return dz;
    }

    public double getDy() {
        return dy;
    }
}
