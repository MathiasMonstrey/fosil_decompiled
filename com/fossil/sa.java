package com.fossil;

import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;

public class sa {
    public int anA;
    public int anB;
    public int anC = 0;
    public int anD = 0;
    public boolean anE;
    public boolean anF;
    public boolean anx = true;
    public int any;
    public int anz;

    public boolean m13495b(s sVar) {
        return this.anz >= 0 && this.anz < sVar.getItemCount();
    }

    public View m13494a(n nVar) {
        View dz = nVar.dz(this.anz);
        this.anz += this.anA;
        return dz;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.any + ", mCurrentPosition=" + this.anz + ", mItemDirection=" + this.anA + ", mLayoutDirection=" + this.anB + ", mStartLine=" + this.anC + ", mEndLine=" + this.anD + '}';
    }
}
