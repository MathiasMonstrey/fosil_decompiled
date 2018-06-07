package com.fossil;

import com.portfolio.platform.enums.Unit;

public final /* synthetic */ class dgs {
    public static final /* synthetic */ int[] cEQ = new int[Unit.values().length];
    public static final /* synthetic */ int[] cTK = new int[Unit.values().length];
    public static final /* synthetic */ int[] cTL = new int[Unit.values().length];

    static {
        cEQ[Unit.IMPERIAL.ordinal()] = 1;
        cEQ[Unit.METRIC.ordinal()] = 2;
        cTK[Unit.IMPERIAL.ordinal()] = 1;
        cTK[Unit.METRIC.ordinal()] = 2;
        cTL[Unit.IMPERIAL.ordinal()] = 1;
        cTL[Unit.METRIC.ordinal()] = 2;
    }
}
