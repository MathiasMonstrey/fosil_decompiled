package com.fossil;

import android.content.Context;
import com.flurry.sdk.ji;
import com.flurry.sdk.jo;
import com.flurry.sdk.ln;

public class aon implements aps {
    public static synchronized aon Il() {
        aon com_fossil_aon;
        synchronized (aon.class) {
            com_fossil_aon = (aon) apc.IO().m4157H(aon.class);
        }
        return com_fossil_aon;
    }

    public void init(Context context) {
        ln.m2789I(apb.class);
        apl.IW();
        aqp.Jf();
        ape.IP();
        jo.ID();
        ji.Iu();
        aou.IE();
        aos.Iy();
        aov.IF();
        aor.Ix();
        apa.IK();
    }

    public static apb Im() {
        ln Jd = aqm.Jc().Jd();
        if (Jd == null) {
            return null;
        }
        return (apb) Jd.m2790K(apb.class);
    }

    public static long In() {
        apb Im = Im();
        if (Im != null) {
            return Im.aXv;
        }
        return 0;
    }

    public static long Io() {
        apb Im = Im();
        if (Im != null) {
            return Im.aXw;
        }
        return 0;
    }

    public static long Ip() {
        apb Im = Im();
        if (Im != null) {
            return Im.aYX;
        }
        return -1;
    }

    public static long Iq() {
        apb Im = Im();
        if (Im != null) {
            return Im.IL();
        }
        return 0;
    }

    public static long Ir() {
        apb Im = Im();
        if (Im != null) {
            return Im.aWN;
        }
        return 0;
    }

    public static int Is() {
        return jo.ID().Iz();
    }
}
