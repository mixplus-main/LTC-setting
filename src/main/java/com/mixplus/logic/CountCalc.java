package com.mixplus.logic;

public class CountCalc {
    private double Diff;
    public CountCalc(double Origin, double Target, double dV) {
        Diff = Target - Origin;
        Diff /= dV;

        System.out.println(Origin);

    }

    public double GetCount() {
        return Diff;
    }
}
