package com.fossil;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.RecyclerView.s;
import android.util.DisplayMetrics;
import android.view.View;

public class sg extends sp {
    private sf apg;
    private sf aph;

    public int[] mo4120a(h hVar, View view) {
        int[] iArr = new int[2];
        if (hVar.pe()) {
            iArr[0] = m13524a(hVar, view, m13528f(hVar));
        } else {
            iArr[0] = 0;
        }
        if (hVar.pf()) {
            iArr[1] = m13524a(hVar, view, m13527e(hVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View mo4121c(h hVar) {
        if (hVar.pf()) {
            return m13525a(hVar, m13527e(hVar));
        }
        if (hVar.pe()) {
            return m13525a(hVar, m13528f(hVar));
        }
        return null;
    }

    public int mo4119a(h hVar, int i, int i2) {
        Object obj = null;
        int itemCount = hVar.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (hVar.pf()) {
            view = m13526b(hVar, m13527e(hVar));
        } else if (hVar.pe()) {
            view = m13526b(hVar, m13528f(hVar));
        }
        if (view == null) {
            return -1;
        }
        int ce = hVar.ce(view);
        if (ce == -1) {
            return -1;
        }
        Object obj2;
        if (hVar.pe()) {
            obj2 = i > 0 ? 1 : null;
        } else if (i2 > 0) {
            int i3 = 1;
        } else {
            obj2 = null;
        }
        if (hVar instanceof b) {
            PointF df = ((b) hVar).df(itemCount - 1);
            if (df != null && (df.x < 0.0f || df.y < 0.0f)) {
                obj = 1;
            }
        }
        if (obj == null) {
            return obj2 != null ? ce + 1 : ce;
        } else {
            if (obj2 != null) {
                return ce - 1;
            }
            return ce;
        }
    }

    protected sb mo4122d(h hVar) {
        if (hVar instanceof b) {
            return new sb(this, this.aqI.getContext()) {
                final /* synthetic */ sg api;

                protected void mo4117a(View view, s sVar, a aVar) {
                    int[] a = this.api.mo4120a(this.api.aqI.getLayoutManager(), view);
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

                protected int dk(int i) {
                    return Math.min(100, super.dk(i));
                }
            };
        }
        return null;
    }

    private int m13524a(h hVar, View view, sf sfVar) {
        int pF;
        int bO = (sfVar.bO(view) / 2) + sfVar.bK(view);
        if (hVar.getClipToPadding()) {
            pF = sfVar.pF() + (sfVar.pH() / 2);
        } else {
            pF = sfVar.getEnd() / 2;
        }
        return bO - pF;
    }

    private View m13525a(h hVar, sf sfVar) {
        View view = null;
        int childCount = hVar.getChildCount();
        if (childCount != 0) {
            int pF;
            if (hVar.getClipToPadding()) {
                pF = sfVar.pF() + (sfVar.pH() / 2);
            } else {
                pF = sfVar.getEnd() / 2;
            }
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < childCount) {
                View view2;
                View childAt = hVar.getChildAt(i2);
                int abs = Math.abs((sfVar.bK(childAt) + (sfVar.bO(childAt) / 2)) - pF);
                if (abs < i) {
                    view2 = childAt;
                } else {
                    abs = i;
                    view2 = view;
                }
                i2++;
                view = view2;
                i = abs;
            }
        }
        return view;
    }

    private View m13526b(h hVar, sf sfVar) {
        View view = null;
        int childCount = hVar.getChildCount();
        if (childCount != 0) {
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < childCount) {
                View view2;
                View childAt = hVar.getChildAt(i2);
                int bK = sfVar.bK(childAt);
                if (bK < i) {
                    view2 = childAt;
                } else {
                    bK = i;
                    view2 = view;
                }
                i2++;
                view = view2;
                i = bK;
            }
        }
        return view;
    }

    private sf m13527e(h hVar) {
        if (this.apg == null || this.apg.ape != hVar) {
            this.apg = sf.m13515b(hVar);
        }
        return this.apg;
    }

    private sf m13528f(h hVar) {
        if (this.aph == null || this.aph.ape != hVar) {
            this.aph = sf.m13513a(hVar);
        }
        return this.aph;
    }
}
