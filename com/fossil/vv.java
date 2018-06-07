package com.fossil;

import com.fossil.vs.C4167a;
import java.io.File;

public class vv implements C4167a {
    private final int aCO;
    private final C4171a aCP;

    public interface C4171a {
        File vl();
    }

    public vv(C4171a c4171a, int i) {
        this.aCO = i;
        this.aCP = c4171a;
    }

    public vs vj() {
        File vl = this.aCP.vl();
        if (vl == null) {
            return null;
        }
        if (vl.mkdirs() || (vl.exists() && vl.isDirectory())) {
            return vw.m13964a(vl, this.aCO);
        }
        return null;
    }
}
