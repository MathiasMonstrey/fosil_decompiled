package com.fossil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.qq.C3962a;
import com.fossil.qr.C4019a;
import java.util.ArrayList;

public abstract class qd implements qq {
    protected LayoutInflater Yg;
    protected Context afk;
    protected LayoutInflater afl;
    private int afm;
    private int afn;
    protected qr afo;
    protected Context mContext;
    private int mId;
    private C3962a uF;
    protected qj uh;

    public abstract void mo4064a(ql qlVar, C4019a c4019a);

    public qd(Context context, int i, int i2) {
        this.afk = context;
        this.afl = LayoutInflater.from(context);
        this.afm = i;
        this.afn = i2;
    }

    public void mo4018a(Context context, qj qjVar) {
        this.mContext = context;
        this.Yg = LayoutInflater.from(this.mContext);
        this.uh = qjVar;
    }

    public qr mo4063a(ViewGroup viewGroup) {
        if (this.afo == null) {
            this.afo = (qr) this.afl.inflate(this.afm, viewGroup, false);
            this.afo.m13207a(this.uh);
            mo4025g(true);
        }
        return this.afo;
    }

    public void mo4025g(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.afo;
        if (viewGroup != null) {
            int i;
            if (this.uh != null) {
                this.uh.mV();
                ArrayList mU = this.uh.mU();
                int size = mU.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    ql qlVar = (ql) mU.get(i2);
                    if (mo4065a(i, qlVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        ql itemData = childAt instanceof C4019a ? ((C4019a) childAt).getItemData() : null;
                        View a = mo4062a(qlVar, childAt, viewGroup);
                        if (qlVar != itemData) {
                            a.setPressed(false);
                            li.al(a);
                        }
                        if (a != childAt) {
                            m13134w(a, i);
                        }
                        i3 = i + 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo4066e(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected void m13134w(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.afo).addView(view, i);
    }

    protected boolean mo4066e(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void mo4020a(C3962a c3962a) {
        this.uF = c3962a;
    }

    public C3962a mE() {
        return this.uF;
    }

    public C4019a m13133l(ViewGroup viewGroup) {
        return (C4019a) this.afl.inflate(this.afn, viewGroup, false);
    }

    public View mo4062a(ql qlVar, View view, ViewGroup viewGroup) {
        C4019a c4019a;
        if (view instanceof C4019a) {
            c4019a = (C4019a) view;
        } else {
            c4019a = m13133l(viewGroup);
        }
        mo4064a(qlVar, c4019a);
        return (View) c4019a;
    }

    public boolean mo4065a(int i, ql qlVar) {
        return true;
    }

    public void mo4019a(qj qjVar, boolean z) {
        if (this.uF != null) {
            this.uF.mo3994a(qjVar, z);
        }
    }

    public boolean mo4022a(qw qwVar) {
        if (this.uF != null) {
            return this.uF.mo3995d(qwVar);
        }
        return false;
    }

    public boolean eW() {
        return false;
    }

    public boolean mo4021a(qj qjVar, ql qlVar) {
        return false;
    }

    public boolean mo4023b(qj qjVar, ql qlVar) {
        return false;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i) {
        this.mId = i;
    }
}
