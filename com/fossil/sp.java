package com.fossil;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.RecyclerView.s;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class sp extends j {
    RecyclerView aqI;
    private final l aqk = new C40811(this);
    private Scroller atg;

    class C40811 extends l {
        boolean ath = false;
        final /* synthetic */ sp ati;

        C40811(sp spVar) {
            this.ati = spVar;
        }

        public void m13557c(RecyclerView recyclerView, int i) {
            super.c(recyclerView, i);
            if (i == 0 && this.ath) {
                this.ath = false;
                this.ati.rR();
            }
        }

        public void m13558g(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.ath = true;
            }
        }
    }

    public abstract int mo4119a(h hVar, int i, int i2);

    public abstract int[] mo4120a(h hVar, View view);

    public abstract View mo4121c(h hVar);

    public boolean aH(int i, int i2) {
        h layoutManager = this.aqI.getLayoutManager();
        if (layoutManager == null || this.aqI.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.aqI.getMinFlingVelocity();
        if ((Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && m13518b(layoutManager, i, i2)) {
            return true;
        }
        return false;
    }

    public void m13523o(RecyclerView recyclerView) throws IllegalStateException {
        if (this.aqI != recyclerView) {
            if (this.aqI != null) {
                rQ();
            }
            this.aqI = recyclerView;
            if (this.aqI != null) {
                rP();
                this.atg = new Scroller(this.aqI.getContext(), new DecelerateInterpolator());
                rR();
            }
        }
    }

    private void rP() throws IllegalStateException {
        if (this.aqI.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.aqI.a(this.aqk);
        this.aqI.setOnFlingListener(this);
    }

    private void rQ() {
        this.aqI.b(this.aqk);
        this.aqI.setOnFlingListener(null);
    }

    private boolean m13518b(h hVar, int i, int i2) {
        if (!(hVar instanceof b)) {
            return false;
        }
        r d = mo4122d(hVar);
        if (d == null) {
            return false;
        }
        int a = mo4119a(hVar, i, i2);
        if (a == -1) {
            return false;
        }
        d.dE(a);
        hVar.a(d);
        return true;
    }

    void rR() {
        if (this.aqI != null) {
            h layoutManager = this.aqI.getLayoutManager();
            if (layoutManager != null) {
                View c = mo4121c(layoutManager);
                if (c != null) {
                    int[] a = mo4120a(layoutManager, c);
                    if (a[0] != 0 || a[1] != 0) {
                        this.aqI.smoothScrollBy(a[0], a[1]);
                    }
                }
            }
        }
    }

    protected sb mo4122d(h hVar) {
        if (hVar instanceof b) {
            return new sb(this, this.aqI.getContext()) {
                final /* synthetic */ sp ati;

                protected void mo4117a(View view, s sVar, a aVar) {
                    int[] a = this.ati.mo4120a(this.ati.aqI.getLayoutManager(), view);
                    int i = a[0];
                    int i2 = a[1];
                    int dj = dj(Math.max(Math.abs(i), Math.abs(i2)));
                    if (dj > 0) {
                        aVar.a(i, i2, dj, this.YU);
                    }
                }

                protected float mo4116a(DisplayMetrics displayMetrics) {
                    return 100.0f / ((float) displayMetrics.densityDpi);
                }
            };
        }
        return null;
    }
}
