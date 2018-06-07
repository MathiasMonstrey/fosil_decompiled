package com.fossil;

import java.util.concurrent.TimeUnit;

public final class bji {
    public static <DP, DT> String m5227a(DP dp, bjg<DP, DT> com_fossil_bjg_DP__DT) {
        bjh Mp = com_fossil_bjg_DP__DT.Mp();
        if (!Mp.dw(com_fossil_bjg_DP__DT.bS(dp))) {
            return null;
        }
        Object bR = com_fossil_bjg_DP__DT.bR(dp);
        for (int i = 0; i < Mp.bT(bR); i++) {
            String t = Mp.mo1255t(bR, i);
            if (com_fossil_bjg_DP__DT.mo1249q(dp, i)) {
                double r = (double) Mp.mo1253r(bR, i);
                if (r == 1.0d) {
                    r = (double) com_fossil_bjg_DP__DT.mo1248p(dp, i);
                } else if (r == 2.0d) {
                    r = com_fossil_bjg_DP__DT.mo1247o(dp, i);
                } else {
                    continue;
                }
                bjl dM = bjj.OH().dM(t);
                if (dM != null && !dM.m5230f(r)) {
                    return "Field out of range";
                }
                bjl Q = bjj.OH().m5229Q(Mp.bU(bR), t);
                if (Q != null) {
                    long a = com_fossil_bjg_DP__DT.mo1244a(dp, TimeUnit.NANOSECONDS);
                    if (a == 0) {
                        return r == 0.0d ? null : "DataPoint out of range";
                    } else {
                        if (!Q.m5230f(r / ((double) a))) {
                            return "DataPoint out of range";
                        }
                    }
                } else {
                    continue;
                }
            } else if (!(Mp.mo1254s(bR, i) || bjj.bvU.contains(t))) {
                return String.valueOf(t).concat(" not set");
            }
        }
        return null;
    }
}
