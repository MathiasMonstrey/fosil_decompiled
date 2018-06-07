package com.fossil;

import android.util.StateSet;
import com.fossil.bj.C1114a;
import com.fossil.bj.C1115b;
import java.util.ArrayList;

final class bh {
    private final ArrayList<C1924a> As = new ArrayList();
    private C1924a At = null;
    bj Au = null;
    private final C1114a Av = new C19231(this);

    class C19231 extends C1115b {
        final /* synthetic */ bh Aw;

        C19231(bh bhVar) {
            this.Aw = bhVar;
        }

        public void mo71b(bj bjVar) {
            if (this.Aw.Au == bjVar) {
                this.Aw.Au = null;
            }
        }
    }

    static class C1924a {
        final int[] Ax;
        final bj Ay;

        C1924a(int[] iArr, bj bjVar) {
            this.Ax = iArr;
            this.Ay = bjVar;
        }
    }

    bh() {
    }

    public void m5154a(int[] iArr, bj bjVar) {
        C1924a c1924a = new C1924a(iArr, bjVar);
        bjVar.m5221a(this.Av);
        this.As.add(c1924a);
    }

    void m5155b(int[] iArr) {
        C1924a c1924a;
        int size = this.As.size();
        for (int i = 0; i < size; i++) {
            c1924a = (C1924a) this.As.get(i);
            if (StateSet.stateSetMatches(c1924a.Ax, iArr)) {
                break;
            }
        }
        c1924a = null;
        if (c1924a != this.At) {
            if (this.At != null) {
                cancel();
            }
            this.At = c1924a;
            if (c1924a != null) {
                m5153a(c1924a);
            }
        }
    }

    private void m5153a(C1924a c1924a) {
        this.Au = c1924a.Ay;
        this.Au.start();
    }

    private void cancel() {
        if (this.Au != null) {
            this.Au.cancel();
            this.Au = null;
        }
    }

    public void jumpToCurrentState() {
        if (this.Au != null) {
            this.Au.end();
            this.Au = null;
        }
    }
}
