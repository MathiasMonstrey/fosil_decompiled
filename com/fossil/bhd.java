package com.fossil;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

public final class bhd<R extends atz> extends aud<R> implements aua<R> {
    private final Object brE;
    private final WeakReference<atv> brG;
    private auc<? super R, ? extends atz> buO;
    private bhd<? extends atz> buP;
    private volatile aub<? super R> buQ;
    private atw<R> buR;
    private Status buS;
    private final bhf buT;
    private boolean buU;

    private final void Or() {
        if (this.buO != null || this.buQ != null) {
            atv com_fossil_atv = (atv) this.brG.get();
            if (!(this.buU || this.buO == null || com_fossil_atv == null)) {
                com_fossil_atv.mo1330a(this);
                this.buU = true;
            }
            if (this.buS != null) {
                m5171m(this.buS);
            } else if (this.buR != null) {
                this.buR.mo1169a((aua) this);
            }
        }
    }

    private final boolean Ot() {
        return (this.buQ == null || ((atv) this.brG.get()) == null) ? false : true;
    }

    private static void m5168f(atz com_fossil_atz) {
        if (com_fossil_atz instanceof atx) {
            try {
                ((atx) com_fossil_atz).release();
            } catch (Throwable e) {
                String valueOf = String.valueOf(com_fossil_atz);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private final void m5170l(Status status) {
        synchronized (this.brE) {
            this.buS = status;
            m5171m(this.buS);
        }
    }

    private final void m5171m(Status status) {
        synchronized (this.brE) {
            if (this.buO != null) {
                Status g = this.buO.m4498g(status);
                awa.m4640p(g, "onFailure must not return null");
                this.buP.m5170l(g);
            } else if (Ot()) {
                this.buQ.mo1185e(status);
            }
        }
    }

    final void Os() {
        this.buQ = null;
    }

    public final void m5172a(atw<?> com_fossil_atw_) {
        synchronized (this.brE) {
            this.buR = com_fossil_atw_;
            Or();
        }
    }

    public final void mo1184a(R r) {
        synchronized (this.brE) {
            if (!r.Ka().Kb()) {
                m5170l(r.Ka());
                m5168f((atz) r);
            } else if (this.buO != null) {
                bgt.NP().submit(new bhe(this, r));
            } else if (Ot()) {
                this.buQ.mo2340b(r);
            }
        }
    }
}
