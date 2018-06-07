package com.fossil;

import android.annotation.SuppressLint;
import com.fossil.vz.C4152a;

public class vy extends abi<ul, vh<?>> implements vz {
    private C4152a aCV;

    public /* synthetic */ vh mo4227b(ul ulVar, vh vhVar) {
        return (vh) super.put(ulVar, vhVar);
    }

    protected /* synthetic */ int bg(Object obj) {
        return m13975j((vh) obj);
    }

    protected /* synthetic */ void m13974h(Object obj, Object obj2) {
        m13971a((ul) obj, (vh) obj2);
    }

    public /* synthetic */ vh mo4229j(ul ulVar) {
        return (vh) super.remove(ulVar);
    }

    public vy(int i) {
        super(i);
    }

    public void mo4226a(C4152a c4152a) {
        this.aCV = c4152a;
    }

    protected void m13971a(ul ulVar, vh<?> vhVar) {
        if (this.aCV != null) {
            this.aCV.mo4199f(vhVar);
        }
    }

    protected int m13975j(vh<?> vhVar) {
        return vhVar.getSize();
    }

    @SuppressLint({"InlinedApi"})
    public void ex(int i) {
        if (i >= 60) {
            tN();
        } else if (i >= 40) {
            trimToSize(wW() / 2);
        }
    }
}
