package com.fossil;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C1221h;
import android.support.v7.widget.RecyclerView.C1251l;
import android.support.v7.widget.RecyclerView.C1260r.C1222b;
import android.support.v7.widget.RecyclerView.C1260r.C1259a;
import android.support.v7.widget.RecyclerView.C1261s;
import android.util.DisplayMetrics;
import android.view.View;

public class dsb extends sg {
    private sf aph;
    private RecyclerView aqI;
    private int doO;

    class C31632 extends C1251l {
        boolean ath = false;
        final /* synthetic */ dsb doQ;

        C31632(dsb com_fossil_dsb) {
            this.doQ = com_fossil_dsb;
        }

        public void mo2677c(RecyclerView recyclerView, int i) {
            super.mo2677c(recyclerView, i);
            if (i == 0 && this.ath) {
                this.doQ.aqI.m1722b((C1251l) this);
                this.doQ.aqI.dg(this.doQ.doO);
            }
        }

        public void mo2678g(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.ath = true;
            }
        }
    }

    class C31643 extends C1251l {
        boolean ath = false;
        final /* synthetic */ dsb doQ;

        C31643(dsb com_fossil_dsb) {
            this.doQ = com_fossil_dsb;
        }

        public void mo2677c(RecyclerView recyclerView, int i) {
            super.mo2677c(recyclerView, i);
            if (i == 0 && this.ath) {
                this.doQ.aqI.m1722b((C1251l) this);
                this.doQ.aqI.dg(this.doQ.doO);
            }
        }

        public void mo2678g(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.ath = true;
            }
        }
    }

    public View m9602c(C1221h c1221h) {
        if (c1221h.pe()) {
            return m9595a(c1221h, m9600f(c1221h));
        }
        return null;
    }

    public int m9601a(C1221h c1221h, int i, int i2) {
        Object obj = null;
        int itemCount = c1221h.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (c1221h.pe()) {
            view = m9599b(c1221h, m9600f(c1221h));
        }
        if (view == null) {
            return -1;
        }
        int ce = ((c1221h.ce(view) / 49) * 49) + 24;
        if (ce == -1) {
            return -1;
        }
        Object obj2;
        int i3;
        if (c1221h.pe()) {
            obj2 = i > 0 ? 1 : null;
        } else if (i2 > 0) {
            i3 = 1;
        } else {
            obj2 = null;
        }
        if (c1221h instanceof C1222b) {
            PointF df = ((C1222b) c1221h).df(itemCount - 1);
            if (df != null && (df.x < 0.0f || df.y < 0.0f)) {
                obj = 1;
            }
        }
        i3 = obj != null ? obj2 != null ? ce - 49 : ce : obj2 != null ? ce + 49 : ce;
        this.doO = i3;
        return this.doO;
    }

    protected sb m9603d(final C1221h c1221h) {
        if (c1221h instanceof C1222b) {
            return new sb(this, this.aqI.getContext()) {
                static final /* synthetic */ boolean $assertionsDisabled = (!dsb.class.desiredAssertionStatus());
                final /* synthetic */ dsb doQ;

                protected void m9589a(View view, C1261s c1261s, C1259a c1259a) {
                    int[] a = this.doQ.a(this.doQ.aqI.getLayoutManager(), view);
                    if ($assertionsDisabled || a != null) {
                        int i = a[0];
                        int i2 = a[1];
                        int dj = dj(Math.max(Math.abs(i), Math.abs(i2)));
                        if (dj > 0) {
                            c1259a.m2475a(i, i2, dj, this.YU);
                            return;
                        }
                        return;
                    }
                    throw new AssertionError();
                }

                protected float m9587a(DisplayMetrics displayMetrics) {
                    return 50.0f / ((float) displayMetrics.densityDpi);
                }

                protected int dk(int i) {
                    return Math.min(100, super.dk(i));
                }

                protected void m9588a(C1259a c1259a) {
                    PointF df = df(qZ());
                    if (df == null || (df.x == 0.0f && df.y == 0.0f)) {
                        c1259a.dF(qZ());
                        stop();
                        return;
                    }
                    a(df);
                    this.aoj = df;
                    View a = this.doQ.m9595a(c1221h, this.doQ.m9600f(c1221h));
                    if ($assertionsDisabled || a != null) {
                        int width = (int) ((((float) this.doQ.aqI.getWidth()) - a.getX()) - ((float) (a.getWidth() / 2)));
                        this.aol = (int) (((float) width) * df.x);
                        this.aom = (int) (df.y * ((float) width));
                        c1259a.m2475a((int) (((float) this.aol) * 1.0f), (int) (((float) this.aom) * 1.0f), (int) (((float) dk(width)) * 1.0f), this.aoi);
                        return;
                    }
                    throw new AssertionError();
                }
            };
        }
        return null;
    }

    private View m9595a(C1221h c1221h, sf sfVar) {
        View view = null;
        int childCount = c1221h.getChildCount();
        if (childCount != 0) {
            int pF;
            if (c1221h.getClipToPadding()) {
                pF = sfVar.pF() + (sfVar.pH() / 2);
            } else {
                pF = sfVar.getEnd() / 2;
            }
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < childCount) {
                View view2;
                View childAt = c1221h.getChildAt(i2);
                int ce = c1221h.ce(childAt) % 49;
                if (ce != 24) {
                    i2 = (int) (((((ce > 24 ? 1.5f : 0.5f) * 49.0f) - ((float) ce)) - 1.0f) + ((float) i2));
                    view2 = view;
                } else {
                    ce = Math.abs((sfVar.bK(childAt) + (sfVar.bO(childAt) / 2)) - pF);
                    if (ce < i) {
                        i = ce;
                        view2 = childAt;
                    } else {
                        view2 = view;
                    }
                }
                i2++;
                view = view2;
            }
        }
        return view;
    }

    private View m9599b(C1221h c1221h, sf sfVar) {
        View view = null;
        int childCount = c1221h.getChildCount();
        if (childCount != 0) {
            int i = Integer.MAX_VALUE;
            int[] iArr = new int[2];
            int i2 = 0;
            while (i2 < childCount) {
                View view2;
                View childAt = c1221h.getChildAt(i2);
                childAt.getLocationOnScreen(iArr);
                if (iArr[0] + childAt.getMeasuredWidth() < 0) {
                    view2 = view;
                } else {
                    int bK = sfVar.bK(childAt);
                    if (bK < i) {
                        i = bK;
                        view2 = childAt;
                    } else {
                        view2 = view;
                    }
                }
                i2 += 7;
                view = view2;
            }
        }
        return view;
    }

    private sf m9600f(C1221h c1221h) {
        if (this.aph == null) {
            this.aph = sf.a(c1221h);
        }
        return this.aph;
    }

    public void m9604o(RecyclerView recyclerView) throws IllegalStateException {
        super.o(recyclerView);
        this.aqI = recyclerView;
    }

    public int awn() {
        return this.doO;
    }

    public void ja() {
        this.doO = (int) (((double) this.doO) - ((this.doO % 49 == 0 ? 0.5d : 1.0d) * 49.0d));
        this.aqI.smoothScrollToPosition(this.doO);
        this.aqI.m1714a(new C31632(this));
        this.aqI.smoothScrollToPosition(this.doO);
    }

    public void arW() {
        this.doO = (int) (((this.doO % 49 == 0 ? 1.5d : 1.0d) * 49.0d) + ((double) this.doO));
        this.aqI.m1714a(new C31643(this));
        this.aqI.smoothScrollToPosition(this.doO);
    }

    public void mg(int i) {
        this.doO -= i * 49;
        this.aqI.dg(this.doO);
    }

    public void awo() {
        this.doO = 24;
        this.aqI.dg(0);
    }
}
