package com.fossil;

import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;

public abstract class so extends e {
    boolean atf = true;

    public abstract boolean mo4093a(v vVar, int i, int i2, int i3, int i4);

    public abstract boolean mo4094a(v vVar, v vVar2, int i, int i2, int i3, int i4);

    public abstract boolean mo4095b(v vVar);

    public abstract boolean mo4096d(v vVar);

    public boolean m13453j(v vVar) {
        return !this.atf || vVar.isInvalid();
    }

    public boolean m13450f(v vVar, c cVar, c cVar2) {
        int i = cVar.left;
        int i2 = cVar.top;
        View view = vVar.arT;
        int left = cVar2 == null ? view.getLeft() : cVar2.left;
        int top = cVar2 == null ? view.getTop() : cVar2.top;
        if (vVar.isRemoved() || (i == left && i2 == top)) {
            return mo4095b(vVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo4093a(vVar, i, i2, left, top);
    }

    public boolean m13451g(v vVar, c cVar, c cVar2) {
        if (cVar == null || (cVar.left == cVar2.left && cVar.top == cVar2.top)) {
            return mo4096d(vVar);
        }
        return mo4093a(vVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
    }

    public boolean m13452h(v vVar, c cVar, c cVar2) {
        if (cVar.left == cVar2.left && cVar.top == cVar2.top) {
            m13430F(vVar);
            return false;
        }
        return mo4093a(vVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
    }

    public boolean m13443a(v vVar, v vVar2, c cVar, c cVar2) {
        int i;
        int i2;
        int i3 = cVar.left;
        int i4 = cVar.top;
        if (vVar2.rk()) {
            i = cVar.left;
            i2 = cVar.top;
        } else {
            i = cVar2.left;
            i2 = cVar2.top;
        }
        return mo4094a(vVar, vVar2, i3, i4, i, i2);
    }

    public final void m13429E(v vVar) {
        m13436L(vVar);
        r(vVar);
    }

    public final void m13430F(v vVar) {
        m13440P(vVar);
        r(vVar);
    }

    public final void m13431G(v vVar) {
        m13438N(vVar);
        r(vVar);
    }

    public final void m13445c(v vVar, boolean z) {
        m13449f(vVar, z);
        r(vVar);
    }

    public final void m13432H(v vVar) {
        m13435K(vVar);
    }

    public final void m13433I(v vVar) {
        m13439O(vVar);
    }

    public final void m13434J(v vVar) {
        m13437M(vVar);
    }

    public final void m13446d(v vVar, boolean z) {
        m13448e(vVar, z);
    }

    public void m13435K(v vVar) {
    }

    public void m13436L(v vVar) {
    }

    public void m13437M(v vVar) {
    }

    public void m13438N(v vVar) {
    }

    public void m13439O(v vVar) {
    }

    public void m13440P(v vVar) {
    }

    public void m13448e(v vVar, boolean z) {
    }

    public void m13449f(v vVar, boolean z) {
    }
}
