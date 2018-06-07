package com.fossil;

import bolts.UnobservedTaskException;
import com.fossil.tn.C4118b;

class tp {
    private tn<?> axQ;

    public tp(tn<?> tnVar) {
        this.axQ = tnVar;
    }

    protected void finalize() throws Throwable {
        try {
            tn tnVar = this.axQ;
            if (tnVar != null) {
                C4118b te = tn.te();
                if (te != null) {
                    te.m13684a(tnVar, new UnobservedTaskException(tnVar.getError()));
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public void tm() {
        this.axQ = null;
    }
}
