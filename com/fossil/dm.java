package com.fossil;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.dh.C2250b;
import com.fossil.dh.C2251c;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(14)
class dm extends dh {
    ArrayList<dh> GN = new ArrayList();
    int GO;
    private boolean GP = true;
    boolean mStarted = false;

    static class C2952a extends C2251c {
        dm GL;

        C2952a(dm dmVar) {
            this.GL = dmVar;
        }

        public void mo1906d(dh dhVar) {
            if (!this.GL.mStarted) {
                this.GL.start();
                this.GL.mStarted = true;
            }
        }

        public void mo1903a(dh dhVar) {
            dm dmVar = this.GL;
            dmVar.GO--;
            if (this.GL.GO == 0) {
                this.GL.mStarted = false;
                this.GL.end();
            }
            dhVar.mo1865b((C2250b) this);
        }
    }

    public /* synthetic */ dh mo1862a(C2250b c2250b) {
        return m6864c(c2250b);
    }

    public /* synthetic */ dh mo1865b(C2250b c2250b) {
        return m6866d(c2250b);
    }

    public /* synthetic */ dh mo1867c(TimeInterpolator timeInterpolator) {
        return m6865d(timeInterpolator);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return hE();
    }

    public /* synthetic */ dh hC() {
        return hE();
    }

    public /* synthetic */ dh mo1871k(long j) {
        return m6869l(j);
    }

    public dm az(int i) {
        switch (i) {
            case 0:
                this.GP = true;
                break;
            case 1:
                this.GP = false;
                break;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    public dm m6867e(dh dhVar) {
        if (dhVar != null) {
            this.GN.add(dhVar);
            dhVar.Gz = this;
            if (this.CZ >= 0) {
                dhVar.mo1871k(this.CZ);
            }
        }
        return this;
    }

    public dm m6869l(long j) {
        super.mo1871k(j);
        if (this.CZ >= 0) {
            int size = this.GN.size();
            for (int i = 0; i < size; i++) {
                ((dh) this.GN.get(i)).mo1871k(j);
            }
        }
        return this;
    }

    public dm m6865d(TimeInterpolator timeInterpolator) {
        return (dm) super.mo1867c(timeInterpolator);
    }

    public dm m6864c(C2250b c2250b) {
        return (dm) super.mo1862a(c2250b);
    }

    public dm m6866d(C2250b c2250b) {
        return (dm) super.mo1865b(c2250b);
    }

    private void hD() {
        C2250b c2952a = new C2952a(this);
        Iterator it = this.GN.iterator();
        while (it.hasNext()) {
            ((dh) it.next()).mo1862a(c2952a);
        }
        this.GO = this.GN.size();
    }

    protected void mo1863a(ViewGroup viewGroup, C3009do c3009do, C3009do c3009do2) {
        Iterator it = this.GN.iterator();
        while (it.hasNext()) {
            ((dh) it.next()).mo1863a(viewGroup, c3009do, c3009do2);
        }
    }

    protected void hB() {
        if (this.GN.isEmpty()) {
            start();
            end();
            return;
        }
        hD();
        if (this.GP) {
            Iterator it = this.GN.iterator();
            while (it.hasNext()) {
                ((dh) it.next()).hB();
            }
            return;
        }
        for (int i = 1; i < this.GN.size(); i++) {
            final dh dhVar = (dh) this.GN.get(i);
            ((dh) this.GN.get(i - 1)).mo1862a(new C2251c(this) {
                final /* synthetic */ dm GR;

                public void mo1903a(dh dhVar) {
                    dhVar.hB();
                    dhVar.mo1865b((C2250b) this);
                }
            });
        }
        dh dhVar2 = (dh) this.GN.get(0);
        if (dhVar2 != null) {
            dhVar2.hB();
        }
    }

    public void mo1864a(dn dnVar) {
        int id = dnVar.view.getId();
        if (m6847a(dnVar.view, (long) id)) {
            Iterator it = this.GN.iterator();
            while (it.hasNext()) {
                dh dhVar = (dh) it.next();
                if (dhVar.m6847a(dnVar.view, (long) id)) {
                    dhVar.mo1864a(dnVar);
                }
            }
        }
    }

    public void mo1866b(dn dnVar) {
        int id = dnVar.view.getId();
        if (m6847a(dnVar.view, (long) id)) {
            Iterator it = this.GN.iterator();
            while (it.hasNext()) {
                dh dhVar = (dh) it.next();
                if (dhVar.m6847a(dnVar.view, (long) id)) {
                    dhVar.mo1866b(dnVar);
                }
            }
        }
    }

    public void mo1860A(View view) {
        super.mo1860A(view);
        int size = this.GN.size();
        for (int i = 0; i < size; i++) {
            ((dh) this.GN.get(i)).mo1860A(view);
        }
    }

    public void mo1861B(View view) {
        super.mo1861B(view);
        int size = this.GN.size();
        for (int i = 0; i < size; i++) {
            ((dh) this.GN.get(i)).mo1861B(view);
        }
    }

    String toString(String str) {
        String dhVar = super.toString(str);
        int i = 0;
        while (i < this.GN.size()) {
            String str2 = dhVar + "\n" + ((dh) this.GN.get(i)).toString(str + "  ");
            i++;
            dhVar = str2;
        }
        return dhVar;
    }

    public dm hE() {
        dm dmVar = (dm) super.hC();
        dmVar.GN = new ArrayList();
        int size = this.GN.size();
        for (int i = 0; i < size; i++) {
            dmVar.m6867e(((dh) this.GN.get(i)).hC());
        }
        return dmVar;
    }
}
