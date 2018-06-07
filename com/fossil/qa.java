package com.fossil;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class qa {
    private long CZ = -1;
    final ArrayList<lz> DN = new ArrayList();
    private boolean abv;
    md aeO;
    private final me aeP = new C40061(this);
    private Interpolator mInterpolator;

    class C40061 extends me {
        private boolean aeQ = false;
        private int aeR = 0;
        final /* synthetic */ qa aeS;

        C40061(qa qaVar) {
            this.aeS = qaVar;
        }

        public void m13105e(View view) {
            if (!this.aeQ) {
                this.aeQ = true;
                if (this.aeS.aeO != null) {
                    this.aeS.aeO.e(null);
                }
            }
        }

        void mx() {
            this.aeR = 0;
            this.aeQ = false;
            this.aeS.mw();
        }

        public void m13106f(View view) {
            int i = this.aeR + 1;
            this.aeR = i;
            if (i == this.aeS.DN.size()) {
                if (this.aeS.aeO != null) {
                    this.aeS.aeO.f(null);
                }
                mx();
            }
        }
    }

    public qa m13107a(lz lzVar) {
        if (!this.abv) {
            this.DN.add(lzVar);
        }
        return this;
    }

    public qa m13108a(lz lzVar, lz lzVar2) {
        this.DN.add(lzVar);
        lzVar2.o(lzVar.getDuration());
        this.DN.add(lzVar2);
        return this;
    }

    public void start() {
        if (!this.abv) {
            Iterator it = this.DN.iterator();
            while (it.hasNext()) {
                lz lzVar = (lz) it.next();
                if (this.CZ >= 0) {
                    lzVar.n(this.CZ);
                }
                if (this.mInterpolator != null) {
                    lzVar.c(this.mInterpolator);
                }
                if (this.aeO != null) {
                    lzVar.a(this.aeP);
                }
                lzVar.start();
            }
            this.abv = true;
        }
    }

    void mw() {
        this.abv = false;
    }

    public void cancel() {
        if (this.abv) {
            Iterator it = this.DN.iterator();
            while (it.hasNext()) {
                ((lz) it.next()).cancel();
            }
            this.abv = false;
        }
    }

    public qa m13111q(long j) {
        if (!this.abv) {
            this.CZ = j;
        }
        return this;
    }

    public qa m13110d(Interpolator interpolator) {
        if (!this.abv) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public qa m13109b(md mdVar) {
        if (!this.abv) {
            this.aeO = mdVar;
        }
        return this;
    }
}
