package com.fossil;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.fossil.ats.C1887c;
import com.fossil.ats.C1888f;
import com.google.android.gms.common.api.Status;

public final class ber implements bfn {
    private final bfo bsG;
    private boolean bsH = false;

    public ber(bfo com_fossil_bfo) {
        this.bsG = com_fossil_bfo;
    }

    final void NA() {
        if (this.bsH) {
            this.bsH = false;
            this.bsG.brW.btr.release();
            disconnect();
        }
    }

    public final void mo1317a(atn com_fossil_atn, ats<?> com_fossil_ats_, boolean z) {
    }

    public final void begin() {
    }

    public final <A extends C1887c, R extends atz, T extends bds<R, A>> T mo1319c(T t) {
        return mo1321d(t);
    }

    public final void connect() {
        if (this.bsH) {
            this.bsH = false;
            this.bsG.m5068a(new bet(this, this));
        }
    }

    public final <A extends C1887c, T extends bds<? extends atz, A>> T mo1321d(T t) {
        try {
            this.bsG.brW.btr.m5174b(t);
            bfg com_fossil_bfg = this.bsG.brW;
            C1887c c1887c = (C1888f) com_fossil_bfg.btl.get(t.Kx());
            awa.m4640p(c1887c, "Appropriate Api was not requested.");
            if (c1887c.isConnected() || !this.bsG.btD.containsKey(t.Kx())) {
                if (c1887c instanceof awj) {
                    awj com_fossil_awj = (awj) c1887c;
                    c1887c = null;
                }
                t.m4410b(c1887c);
                return t;
            }
            t.m4411i(new Status(17));
            return t;
        } catch (DeadObjectException e) {
            this.bsG.m5068a(new bes(this, this));
        }
    }

    public final boolean disconnect() {
        if (this.bsH) {
            return false;
        }
        if (this.bsG.brW.NL()) {
            this.bsH = true;
            for (bhd Os : this.bsG.brW.btq) {
                Os.Os();
            }
            return false;
        }
        this.bsG.m5073j(null);
        return true;
    }

    public final void hr(int i) {
        this.bsG.m5073j(null);
        this.bsG.btH.mo1297t(i, this.bsH);
    }

    public final void mo1324l(Bundle bundle) {
    }
}
