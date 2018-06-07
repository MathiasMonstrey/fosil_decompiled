package com.misfit.ble.obfuscated;

import android.os.Bundle;
import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.obfuscated.bo.C4498a;
import com.misfit.ble.obfuscated.bo.C4499b;
import com.misfit.ble.obfuscated.cz.C4517a;
import com.misfit.ble.obfuscated.da.C4521a;
import com.misfit.ble.obfuscated.de.C4525a;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.ble.shine.ShineProfile.SyncCallback;
import com.misfit.ble.util.MutableBoolean;

public class bp extends bo {
    public bp(C4463a c4463a, SyncCallback syncCallback, C4498a c4498a, boolean z, boolean z2) {
        super(c4463a, syncCallback, c4498a, z, z2);
    }

    protected void mo4820a(ew ewVar, int i) {
        super.mo4820a(ewVar, i);
        if (i == 1) {
            m14963c(C4464b.RESULT_RECEIVE_RESPONSE_FAILED);
        } else if (i == 2) {
            m14963c(C4464b.RESULT_TIMED_OUT);
        } else if (ewVar instanceof de) {
            C4525a cp = ((de) ewVar).cp();
            if (cp.result == (byte) 0) {
                this.ij.io = cp.lm;
                C4499b c4499b = this.ij;
                this.ij.iq = (short) 0;
                c4499b.ip = (short) 0;
                this.ij.ir = cp.ln;
                if (this.ij.io <= (short) 0) {
                    m14963c(C4464b.RESULT_SUCCESS);
                } else if (this.im) {
                    m14787c(m14960a(cp.class));
                } else {
                    m14787c(m14960a(da.class));
                }
            } else if (cp.kT == (byte) 4) {
                this.hk = true;
                m14787c(m14960a(cu.class));
            } else {
                m14963c(C4464b.RESULT_REQUEST_ERROR);
            }
        } else if (ewVar instanceof da) {
            da daVar = (da) ewVar;
            C4521a cj = daVar.cj();
            if (daVar.ck()) {
                bl();
            } else if (cj.result != (byte) 0) {
                m14963c(C4464b.RESULT_REQUEST_ERROR);
            } else {
                float f = 0.0f;
                short s = this.ij.io;
                if (s != (short) 0) {
                    f = (((float) (this.ij.ip + 1)) * 1.0f) / ((float) s);
                }
                if (cj.kV == null) {
                    m14963c(C4464b.RESULT_RESPONSE_PARSE_ERROR);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putFloat(ShineProfile.SYNC_PROGRESS_KEY, f);
                MutableBoolean mutableBoolean = new MutableBoolean(Boolean.valueOf(false));
                this.ik.mo4929a(this, cj.kV, bundle, mutableBoolean, this.il);
                if (mutableBoolean.getValue()) {
                    m14963c(C4464b.RESULT_INTERRUPTED);
                } else {
                    bl();
                }
            }
        } else if (ewVar instanceof cp) {
            if (((cp) ewVar).cf().result != (byte) 0) {
                m14963c(C4464b.RESULT_REQUEST_ERROR);
            } else {
                m14787c(m14960a(cx.class));
            }
        } else if (ewVar instanceof cx) {
            C4517a ci = ((cx) ewVar).ci();
            if (this.ij.iq >= this.ij.io && ci.result == (byte) 1 && (ci.kT == (byte) 2 || ci.kT == (byte) 1)) {
                m14963c(C4464b.RESULT_SUCCESS);
            } else if (ci.result != (byte) 0) {
                m14963c(C4464b.RESULT_REQUEST_ERROR);
            } else {
                C4499b c4499b2 = this.ij;
                c4499b2.iq = (short) (c4499b2.iq + 1);
                m14787c(m14960a(cx.class));
            }
        }
    }
}
